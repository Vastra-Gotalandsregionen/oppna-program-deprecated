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
package se.vgr.javg.poc.versioning.client;

import org.junit.Assert;
import se.vgr.javg.poc.versioning.common.testsupport.ClientFactory;
import se.vgr.javg.poc.versioning.schema.address.v1.AddressType;
import se.vgr.javg.poc.versioning.schema.category.v1.CategoryType;
import se.vgr.javg.poc.versioning.schema.contact.v1.ContactType;
import se.vgr.javg.poc.versioning.wsdl.contactservice.v1.ContactService;

public class ContactServiceClient_v1_2 {

	public static void testContactService() {
		ContactType contact = new ContactType();
		contact.setId(1);
		contact.setName("aName");

		// v1.1 increment
		CategoryType ctg = new CategoryType();
		ctg.setName("aCategoryName");
		contact.setCategory(ctg);

		// v1.2 increment
		AddressType at = new AddressType();
		at.setStreet("cStreet");
		at.setCity("cCity");
		contact.setAddress(at);

		ContactService client = (ContactService) ClientFactory.getClient();
		ContactType replyContact = client.createContact(contact);

		Assert.assertEquals(1, replyContact.getId());
		Assert.assertEquals("aName", replyContact.getName());
		Assert.assertNotNull(replyContact.getCategory());
		Assert.assertEquals("aCategoryName", replyContact.getCategory()
				.getName());
		Assert.assertNotNull(replyContact.getAddress());
		Assert.assertEquals("cStreet", replyContact.getAddress().getStreet());
		Assert.assertEquals("cCity", replyContact.getAddress().getCity());

		System.out.println("Done.");
	}

	public static void main(String[] args) {
		testContactService();
	}
}
