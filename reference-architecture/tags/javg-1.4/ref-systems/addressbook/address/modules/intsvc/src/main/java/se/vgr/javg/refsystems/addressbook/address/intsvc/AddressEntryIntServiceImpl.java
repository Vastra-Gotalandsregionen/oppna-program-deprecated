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
package se.vgr.javg.refsystems.addressbook.address.intsvc;

import java.util.Arrays;

import se.vgr.core.schema.addressentry.v1.AddressEntryListType;
import se.vgr.core.schema.addressentry.v1.AddressEntryType;
import se.vgr.core.schema.category.v1.CategoryListType;
import se.vgr.javg.refsystems.addressbook.address.schema.AddressEntrySdoHelper;
import se.vgr.javg.refsystems.addressbook.address.svc.AddressService;

/**
 * A Simple Integration Service (web service) implementation. It implements a
 * JAX-WS-generated SEI.
 */
public class AddressEntryIntServiceImpl implements
		se.vgr.core.wsdl.addressservices.v1.AddressService {

	private AddressService addressService;

	/**
	 * Dependent composite service AddressService - to be injected.
	 * 
	 * @return
	 */
	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * Retrieves AddressEntry model objects from the AddressService. The
	 * resulting entries are then copied to corresponding service data objects
	 * to be returned to the WebService infrastructure.
	 */
	public AddressEntryListType getAddressEntries(String dummy) {
		return AddressEntrySdoHelper.toAddressEntryListType(Arrays
				.asList(getAddressService().getAddressEntries()));
	}

	public AddressEntryType getAddressEntry(long body) {
		return AddressEntrySdoHelper.toAddressEntryType(getAddressService()
				.getAddressEntry(body));
	}

	public CategoryListType getCategories(String dummy) {
		CategoryListType returnValue = new CategoryListType();
		for (String category : getAddressService().getCategories()) {
			returnValue.getCategory().add(category);
		}
		return returnValue;
	}

	public void saveAddressEntry(AddressEntryType body) {
		getAddressService().saveAddressEntry(
				AddressEntrySdoHelper.fromAddressEntryType(body));
	}

	public void saveCategory(String body) {
		getAddressService().saveCategory(body);
	}

}
