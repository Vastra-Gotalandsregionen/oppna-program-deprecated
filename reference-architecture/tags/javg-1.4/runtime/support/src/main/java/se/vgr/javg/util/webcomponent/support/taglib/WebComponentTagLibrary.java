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
package se.vgr.javg.util.webcomponent.support.taglib;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import com.sun.facelets.tag.AbstractTagLibrary;

/**
 * From example: http://www-128.ibm.com/developerworks/web/library/j-facelets2.html
 * 
 * @author hakan
 */
public class WebComponentTagLibrary extends AbstractTagLibrary {
	/** Namespace used to import this library in Facelets pages */
    public static final String NAMESPACE = "http://www.vgr.se/javg-util/webcomponent";
    /** Current instance of library. */
    public static final WebComponentTagLibrary INSTANCE = new WebComponentTagLibrary();	

	public WebComponentTagLibrary() {
        super(NAMESPACE);

        try {
            Method[] methods = WebComponentTagFunctions.class.getMethods();

            for (int i = 0; i < methods.length; i++) {
                if (Modifier.isStatic(methods[i].getModifiers())) {
                    this.addFunction(methods[i].getName(), methods[i]);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}	
}
