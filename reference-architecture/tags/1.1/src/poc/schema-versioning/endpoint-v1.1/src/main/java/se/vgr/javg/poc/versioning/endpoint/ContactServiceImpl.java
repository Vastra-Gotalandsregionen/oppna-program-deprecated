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
package se.vgr.javg.poc.versioning.endpoint;

import se.vgr.javg.poc.versioning.common.testsupport.EndpointTestRunner;
import se.vgr.javg.poc.versioning.schema.category.v1.CategoryType;
import se.vgr.javg.poc.versioning.schema.contact.v1.ContactType;
import se.vgr.javg.poc.versioning.wsdl.contactservice.v1.ContactService;

public class ContactServiceImpl extends EndpointTestRunner implements
		ContactService {

	public ContactType createContact(ContactType parameters) {
		// note should not really have an id set here - primaryKey should be
		// assigned but use as is for testing only

		// add incremental change for v1.1
		if (parameters.getCategory() == null) {
			parameters.setCategory(getCategory());
		}

		return parameters;
	}

	public ContactType getContact(long parameters) {
		ContactType ct = new ContactType();
		ct.setId(parameters);
		ct.setName("name for id: " + parameters);
		// add incremental change for v1.1
		ct.setCategory(getCategory());
		return ct;
	}

	private CategoryType getCategory() {
		CategoryType ctg = new CategoryType();
		ctg.setName("aCategory");
		return ctg;
	}

	public void saveContact(ContactType parameters) {
		StringBuilder sb = new StringBuilder();
		sb.append("saveContact, id: ").append(parameters.getId()).append(
				", name: ").append(parameters.getName());
		System.out.println(sb);
	}

	public static void main(String args[]) {
		EndpointTestRunner.start();
	}
}
