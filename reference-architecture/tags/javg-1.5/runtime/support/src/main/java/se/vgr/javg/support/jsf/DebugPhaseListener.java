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
package se.vgr.javg.support.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Simple debug-helper for JSF.
 * <p>
 * Needs configuration in faces-config.xml:
 * 
 * <pre>
 * &lt;lifecycle&gt;
 *   &lt;phase-listener&gt;se.vgr.javg.support.jsf.DebugPhaseListener&lt;/phase-listener&gt;
 * </pre>
 */
public class DebugPhaseListener implements PhaseListener {
	private Log log = LogFactory.getLog(DebugPhaseListener.class);

	public void beforePhase(PhaseEvent pe) {
		if (log.isDebugEnabled()) {
			log.debug("beforePhase: " + pe.getPhaseId());
		}
	}

	public void afterPhase(PhaseEvent pe) {
		if (log.isDebugEnabled()) {
			log.debug("afterPhase: " + pe.getPhaseId());
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
