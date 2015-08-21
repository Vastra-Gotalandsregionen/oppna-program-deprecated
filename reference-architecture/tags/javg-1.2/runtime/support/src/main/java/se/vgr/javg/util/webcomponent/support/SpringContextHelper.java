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

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Helper for loading and accessing Spring application contexts. This class
 * keeps a singleton to the loaded root context.
 *
 * The property spring.cxf.config is used to control the spring configuration
 * file to load. The system can have different configuration files for different
 * environments. One file can be used for deployment to target environment and
 * another can be used for testing out-of-container.
 *
 * The spring context to load is determined by the property spring.cxf.config.
 * By setting this property to a different value another spring context file
 * can be loaded.
 */
public final class SpringContextHelper {

    /**
     * Since this is a Utility class, it should never be instantiated.
     */
    private SpringContextHelper() {
    }

    private static ConfigurableApplicationContext rootContext;

    /**
     * System property name for overriding the root context filename. <br>
     * value = spring.cxf.config.
     */
    public static final String ROOT_CONTEXT_SYSTEM_PROP = "spring.cxf.config";

    /**
     * Default system context filename. <br>
     * value = classpath:spring-system-def-j2ee.xml.
     */
    public static final String DEFAULT_SYSTEM_CONTEXT_URL = "classpath:spring-cxf-config.xml";

    /**
     * Returns the application context. The application context is expected
     * to be configured by defintion config files.
     *
     * @return the application context
     */
    public static synchronized ConfigurableApplicationContext getContext() {
        if (rootContext == null) {
            String rootContextUrl = System.getProperty(ROOT_CONTEXT_SYSTEM_PROP);
            if (rootContextUrl == null) {
                rootContextUrl = DEFAULT_SYSTEM_CONTEXT_URL;
            }
            rootContext = new ClassPathXmlApplicationContext(rootContextUrl);
        }
        return rootContext;
    }

    /**
     * Resets the static field acting as a cache. Next call to
     * getContext() will force the context to be reloaded.
     *
     */
    public static synchronized void invalidateContextCache() {
        rootContext = null;
    }

}
