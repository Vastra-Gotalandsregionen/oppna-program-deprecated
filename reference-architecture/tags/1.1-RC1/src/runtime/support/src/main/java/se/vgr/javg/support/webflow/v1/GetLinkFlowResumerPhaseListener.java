/* Copyright 2009 Västa Götalandsregionen

  This library is free software; you can redistribute it and/or modify
  it under the terms of version 2.1 of the GNU Lesser General Public
  License as published by the Free Software Foundation.

  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU Lesser General Public License for more details.

  You should have received a copy of the GNU Lesser General Public
  License along with this library; if not, write to the
  Free Software Foundation, Inc., 59 Temple Place, Suite 330,
  Boston, MA 02111-1307  USA
*/
package se.vgr.javg.support.webflow.v1;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.webflow.context.ExternalContextHolder;
import org.springframework.webflow.executor.jsf.FlowExecutionHolderUtils;
import org.springframework.webflow.executor.jsf.FlowExecutionKeyStateHolder;
import org.springframework.webflow.executor.jsf.FlowNavigationHandler;

/**
 * Support for using GET-links with JSF/Webflow to resume an existing flow.
 * <p>
 * This PhaseListener provides a way to navigate with GET-links and resume an
 * existing flow. The Facelets-XHTML page should look something like:
 * 
 * <pre>
 *   &lt;a href=&quot;getlink?_linkflowkey=${flowExecutionKey}&amp;_linkeventid=an-event-in-the-current-state;myId=2&quot;&gt;myId=2&lt;/a&gt;
 * </pre>
 * 
 * where the <i>myId</i> parameter can be used with a Webflow input-mapper in
 * the flow-definition to pass a request-parameter into the flow.
 * <p>
 * Must be configured in faces-config.xml <b>before</b> the Webflow
 * FlowPhaseListener for events to be processed in the correct order:
 * 
 * <pre>
 * &lt;lifecycle&gt;
 *   &lt;phase-listener&gt;
 * 	   hd.test.GetLinkFlowResumerPhaseListener
 *   &lt;/phase-listener&gt;
 *   &lt;phase-listener&gt;
 *     org.springframework.webflow.executor.jsf.FlowPhaseListener
 *   &lt;/phase-listener&gt;
 * </pre>
 * 
 * <p>
 * Also refer to {@link JSFWebFlowGetRequestDispatcher} for URL-mapping of
 * GET-requests.
 * 
 * <p>
 * Tested with Webflow 1.0.5.
 * 
 * @see JSFWebFlowGetRequestDispatcher
 * @see org.springframework.webflow.executor.jsf.FlowPhaseListener
 */
public class GetLinkFlowResumerPhaseListener implements PhaseListener {
	private Log log = LogFactory.getLog(GetLinkFlowResumerPhaseListener.class);
	public static final String GET_LINK_FLOW_EXECUTION_KEY = "_linkflowkey";
	public static final String GET_LINK_EVENT_ID = "_linkeventid";

	public void beforePhase(PhaseEvent event) {
		// if this is a GET-navigation we must signal a navigation event
		// which is normally done in the INVOKE_APPLICATION phase - but that
		// phase will never be invoked during a GET-request (only RESTORE_VIEW
		// and RENDER_RESPONSE will be invoked).
		if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {
			if (hasGetLinkFlowExecutionKey(event.getFacesContext())) {
				if (log.isDebugEnabled()) {
					log.debug("will signal navigation event");
				}
				handleNavigation(event.getFacesContext());
			}
		}
	}

	public void afterPhase(PhaseEvent event) {
		// if this is a GET-navigation we must fake restoration of the Webflow
		// flowExecutionKey (which is normally done from the restored Faces
		// UI-state)
		if (event.getPhaseId() == PhaseId.RESTORE_VIEW) {
			Object flowExecutionKey = extractGetLinkFlowExecutionKey(event
					.getFacesContext());
			if (flowExecutionKey != null) {
				if (log.isDebugEnabled()) {
					log.debug("will restore flow execution key: "
							+ flowExecutionKey);
				}
				restoreFlowExecution(event.getFacesContext(),
						(String) flowExecutionKey);
			}
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	private boolean hasGetLinkFlowExecutionKey(FacesContext facesContext) {
		return extractGetLinkFlowExecutionKey(facesContext) != null;
	}

	private Object extractGetLinkFlowExecutionKey(FacesContext facesContext) {
		return facesContext.getExternalContext().getRequestParameterMap().get(
				GET_LINK_FLOW_EXECUTION_KEY);
	}

	private Object extractGetLinkEventId(FacesContext facesContext) {
		return facesContext.getExternalContext().getRequestParameterMap().get(
				GET_LINK_EVENT_ID);
	}

	private void cleanupResources(FacesContext context) {
		FlowExecutionHolderUtils.cleanupCurrentFlowExecution(context);
		ExternalContextHolder.setExternalContext(null);
	}

	/**
	 * We must provide the flowExecutionKey-key - but not as param with that
	 * name since Webflow interprets that as a refresh of the current flow
	 * (which has no side-effects).
	 * 
	 * @see org.springframework.webflow.executor.jsf.FlowExecutionKeyStateHolder#restoreFlowExecution(javax.faces.context.FacesContext)
	 * @param facesContext
	 */
	private void restoreFlowExecution(FacesContext facesContext,
			String flowExecutionKey) {
		FlowExecutionKeyStateHolder flowExecutionKeyStateHolder = new FlowExecutionKeyStateHolder();
		// fake restore that is normally done by the Faces-restore-view
		// machinery, will also restore the flow execution
		Object[] state = new Object[1];
		state[0] = flowExecutionKey;
		flowExecutionKeyStateHolder.restoreState(facesContext, state);
	}

	/**
	 * A HTTP-GET-request will not trigger the Faces invoke-application state in
	 * the life-cycle (only the restore-view and render-view) since it is not a
	 * Faces-postback, hence we need to trigger the navigation ourselves at this
	 * point by signalling an event to Webflow as would have happend in the
	 * Webflow-navigationhandler.
	 * 
	 * @see org.springframework.webflow.executor.jsf.FlowNavigationHandler#handleNavigation(FacesContext,
	 *      String, String, javax.faces.application.NavigationHandler)
	 */
	private void handleNavigation(FacesContext facesContext) {
		Object eventId = extractGetLinkEventId(facesContext);
		if (eventId == null) {
			// must cleanup here since we are in the last phase (RENDER)
			cleanupResources(facesContext);
			throw new IllegalStateException("The parameter: "
					+ GET_LINK_EVENT_ID + " must be provided when using the "
					+ GET_LINK_FLOW_EXECUTION_KEY
					+ " parameter for HTTP-GET flow navigation");
		}

		if (log.isDebugEnabled()) {
			log.debug("extracted navigation eventId: " + eventId);
		}

		FlowNavigationHandler navigationHandler = new FlowNavigationHandler();
		String fromAction = getClass().toString();
		String outcome = (String) eventId;
		// TODO: fix nav-handler - null might cause nasty exceptions that are
		// hard to track down
		NavigationHandler originalNavigationHandler = null;
		navigationHandler.handleNavigation(facesContext, fromAction, outcome,
				originalNavigationHandler);
	}
}
