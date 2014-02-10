/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inkubator.webcore.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Deni Husni FR
 */
public class Primefaces35PhaseListener implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        
    }

    @Override
    public void beforePhase(PhaseEvent event) {
//         FacesContext context = event.getFacesContext();
//
//       if (context.getAttributes().get(Constants.REQUEST_CONTEXT_ATTR) == null) {
//            context.getAttributes().put(Constants.REQUEST_CONTEXT_ATTR, new DefaultRequestContext());
//       } 
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE; 
    }
    
}
