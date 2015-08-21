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

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Javg Specialization of the Spring Context loader plugin for the web tier.
 * Wraps the ApplicationContext maintained by Javg SpringContextHelper into a
 * WrappingWebApplicationContext.
 */
public class ContextLoader extends org.springframework.web.context.ContextLoader {

    private ConfigurableApplicationContext parentApplicationContext;
 
    /**
     * Default constructor.
     */   
    public ContextLoader() {
    }

    /**
     * Create a ContextLoader which uses a specified ApplicationContext as parent.
     * @param parentApplicationContext parent ApplicationContext
     */   
    public ContextLoader(ConfigurableApplicationContext parentApplicationContext) {
        this.parentApplicationContext = parentApplicationContext;
    }

    /**
     * Instantiate a WrappingWebApplicationContext for this loader,
     * which wraps the ApplicationContext maintained by Janvg SpringContextHelper.
     * @param servletContext current servlet context
     * @param parent parent ApplicationContext (will be ignored!)
     * @see org.springframework.web.context.ContextLoader
     */
    protected WebApplicationContext createWebApplicationContext(
        ServletContext servletContext,
        ApplicationContext parent) {
        if (parentApplicationContext == null) {
            parentApplicationContext = (ConfigurableApplicationContext) SpringContextHelper.getContext();
        }
        XmlWebApplicationContext wac = new XmlWebApplicationContext() {
            public String[] getConfigLocations() {
                return null;
            }
        };
        wac.setParent(parentApplicationContext);
        wac.setServletContext(servletContext);
        wac.refresh();
        return wac;
    }

}
