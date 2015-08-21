/*  Copyright 2009 Västa Götalandsregionen

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
package se.vgr.javg.poc.versioning.common.testsupport;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class ClientFactory {
	private static final String SEI_CLASS = "se.vgr.javg.poc.versioning.wsdl.contactservice.v1.ContactService";

	@SuppressWarnings("unchecked")
	public static Object getClient() {
		try {
			Class seiClass = Class.forName(SEI_CLASS);
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
			factory.setServiceClass(seiClass);
			factory.setAddress(TestConfig.getEndpointAddress());
			return factory.create();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(
					"Could not load SEI class: " + SEI_CLASS, e);
		}
	}
}
