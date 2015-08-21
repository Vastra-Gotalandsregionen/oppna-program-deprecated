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

import javax.xml.ws.Endpoint;

public class EndpointTestRunner {
	private static final String SEI_IMPL_CLASS = "se.vgr.javg.poc.versioning.endpoint.ContactServiceImpl";
	private Endpoint endpoint;

	@SuppressWarnings("unchecked")
	public Object getSEIImpl() {
		try {
			Class seiImplClass = Class.forName(SEI_IMPL_CLASS);
			return seiImplClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Error during initialization of runner",
					e);
		}
	}

	public void startEndpoint() {
		endpoint = Endpoint.publish(TestConfig.getEndpointAddress(),
				getSEIImpl());
		System.out.println("Started endpoint: "
				+ TestConfig.getEndpointAddress());
	}

	public void stopEndpoint() {
		endpoint.stop();
		System.out.println("Stopped endpoint: "
				+ TestConfig.getEndpointAddress());
	}

	public static void start() {
		EndpointTestRunner etr = new EndpointTestRunner();
		etr.startEndpoint();
	}

}
