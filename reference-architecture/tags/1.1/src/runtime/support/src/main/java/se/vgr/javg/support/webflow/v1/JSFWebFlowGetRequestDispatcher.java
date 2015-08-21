/* Copyright 2009 VŠsta Gštalandsregionen

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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for using GET-links with JSF/Webflow without refering directly to a
 * JSF-page.
 * <p>
 * Refering to JSF-pages with GET-links are not necessary when Webflow and the
 * {@link GetLinkFlowResumerPhaseListener} is used (and JSF-pages should never
 * be directly refered in a view - would effectively link views together
 * reducing re-usability).
 * <p>
 * Either a new flow is started with a link like:
 * 
 * <pre>
 *   /getlink?_flowId=my-flow-id
 * </pre>
 * 
 * or an existing flow is resumed (with the aid of
 * {@link GetLinkFlowResumerPhaseListener}):
 * 
 * <pre>
 *   /getlink?_linkflowkey=current-flow-execution-key&amp;_linkeventid=an-event-in-the-current-state
 * </pre>
 * <p>
 * Needs configuration in web.xml:
 * 
 * <pre>
 * &lt;servlet&gt;
 *   &lt;servlet-name&gt;JSFWebFlowGetRequestDispatcher&lt;/servlet-name&gt;
 *   &lt;servlet-class&gt;se.vgr.javg.support.webflow.v1.JSFWebFlowGetRequestDispatcher&lt;/servlet-class&gt;
 * &lt;/servlet&gt;
 * &lt;servlet-mapping&gt;
 *   &lt;servlet-name&gt;JSFWebFlowGetRequestDispatcher&lt;/servlet-name&gt;
 *   &lt;url-pattern&gt;/getlink&lt;/url-pattern&gt;
 * &lt;/servlet-mapping&gt;
 * 
 * </pre>
 * 
 * @see GetLinkFlowResumerPhaseListener
 */
public class JSFWebFlowGetRequestDispatcher extends HttpServlet {
	public static final String FAKE_JSF_PAGE_FOR_REDIRECT = "/getlink.jsf";
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// just forward the request to the Faces servlet and the Webflow
		// machinery
		request.getRequestDispatcher(FAKE_JSF_PAGE_FOR_REDIRECT).forward(
				request, response);
	}

	/**
	 * POST is not allowed against this servlet, it would be a programming error
	 * since it is only designed to respond on GET-requests.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		throw new UnsupportedOperationException(
				"POST not allowed. Only GET is expected. Requested: "
						+ request.getRequestURI());
	}
}
