package se.vgr.javg.support.webflow.v2;

import javax.el.ELContext;
import javax.el.MethodExpression;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.faces.webflow.JsfUtils;

public class EventIdPhaseListener implements PhaseListener {

  public void afterPhase(PhaseEvent event) {
    if (JsfUtils.isFlowRequest()) {
      FacesContext context = event.getFacesContext();
      if (context.getExternalContext().getRequestParameterMap().containsKey("_eventId")) {
        UICommand eventSource = new UICommand();
        eventSource.setTransient(true);
        eventSource.setParent(context.getViewRoot());
        eventSource.setId("_eventId");
        String eventId = context.getExternalContext().getRequestParameterMap().get("_eventId");
        eventSource.setActionExpression(convertEventIdToMethodExpression(context, eventId));
        context.getViewRoot().queueEvent(new ActionEvent(eventSource));
      }
    }
  }

  public void beforePhase(PhaseEvent event) {
    // Do Nothing
  }

  public PhaseId getPhaseId() {
    return PhaseId.APPLY_REQUEST_VALUES;
  }

  private MethodExpression convertEventIdToMethodExpression(FacesContext facesContext, String eventId) {
    ELContext elContext = facesContext.getELContext();
    return facesContext.getApplication().getExpressionFactory().createMethodExpression(elContext, eventId, String.class, new Class[0]);
  }
}