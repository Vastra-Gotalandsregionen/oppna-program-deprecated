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
package se.vgr.javg.refsystems.addressbook.addresswsclient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.vgr.core.schema.addressentry.v1.AddressEntryListType;
import se.vgr.core.schema.addressentry.v1.AddressEntryType;
import se.vgr.core.wsdl.addressservices.v1.AddressService;

/**
 * Webservice client example in a minimal format.
 * <p>
 * Run as main-class.
 * <p>
 * The URL for the service-endpoint is configured in the Spring config file.
 */
public class AddressBookIntSvcClient {
	private AddressService addressService;

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * Invoke service and list all entries.
	 */
	public void listEntries() {
		AddressEntryListType entries = addressService
				.getAddressEntries("dummyArg - see WSDL for explanation");

		for (AddressEntryType aet : entries.getAddressEntry()) {
			System.out.println("Entry: id=" + aet.getEntryId() + ", name="
					+ aet.getName());
		}
	}

	public static void main(String[] args) throws Exception {
		AddressBookIntSvcClient client = new AddressBookIntSvcClient();
		/*
		 * Start the Spring container and get the integration service (intsvc,
		 * webservice) bean. Note that this is only to keep the example at a
		 * minimum. A more normal case in a webapp would be to configure
		 * Spring's ContextLoaderListener in web.xml (see the AddressBook webapp
		 * on how to do that) and have the bean injected.
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"services-config.xml");
		AddressService addressService = (AddressService) ac
				.getBean("Address.AddressEntryServiceIntServiceClient");
		client.setAddressService(addressService);
		client.listEntries();
	}

}
