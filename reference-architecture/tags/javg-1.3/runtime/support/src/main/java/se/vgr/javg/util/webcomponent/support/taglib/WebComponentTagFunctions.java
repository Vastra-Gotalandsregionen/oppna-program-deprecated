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
package se.vgr.javg.util.webcomponent.support.taglib;

import javax.faces.context.FacesContext;

public class WebComponentTagFunctions {
	
	private WebComponentTagFunctions() {
	}
	
	/** 
	 * @return the context path for the webapp
	 */
	public static final String ctxPath() {
		String ctxPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
		return ctxPath + "/";
	}

	/** 
	 * @return the encoded name (for uniqueness in a page)
	 */
	public static final String encNs(String name) {
		return FacesContext.getCurrentInstance().getExternalContext().encodeNamespace(name);
	}	
}
