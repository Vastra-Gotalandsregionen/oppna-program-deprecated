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
package se.vgr.javg.util.webcomponent.support;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import com.sun.facelets.impl.DefaultResourceResolver;

/**
 * Facelets view resolver for resolving views in the classpath.
 */
public class FaceletsClasspathResourceResolver extends DefaultResourceResolver { 

	public URL resolveUrl(String resource) {
//System.out.println("DEBUG: Requested: " + resource);		
		URL resolved = super.resolveUrl(resource);
				
		if (resolved == null) {
			try {
				String classPathUrl =resource.substring(1);				
				Enumeration urls = Thread.currentThread().getContextClassLoader().getResources(classPathUrl);
				if (!urls.hasMoreElements()) {
					urls = getClass().getClassLoader().getResources(classPathUrl);
					if (!urls.hasMoreElements()) {
						throw new RuntimeException("Could not resolve resource: " + resource);	
					}
				}
				resolved = (URL) urls.nextElement();
			}
			catch (IOException e) {
				throw new RuntimeException("Error when resolving resource: " + resource, e);
			}
		}
		return resolved;
	}
}
