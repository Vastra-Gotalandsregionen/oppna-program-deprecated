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
package se.vgr.javg.refsystems.addressbook.address.presentation;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import se.vgr.javg.refsystems.addressbook.address.svc.AddressService;
import se.vgr.javg.refsystems.addressbook.address.types.AddressEntry;

/**
 * Fetch details and allow for updating or creating a new entry.
 */
public class AddressEntryFlowSupportBean {

	private AddressService addressService;

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public List<SelectItem> getCategories() {
		// initialize select-list
		List<SelectItem> categories = new ArrayList<SelectItem>();
		for (String category : getAddressService().getCategories()) {
			categories.add(new SelectItem(category, category, ""));
		}
		return categories;
	}

	public void saveEntry(AddressEntry entry) {
		getAddressService().saveAddressEntry(entry);
	}

	public AddressEntry getNewOrExistingAddressEntry(Object entryId) {
		return entryId == null ? getNewAddressEntry() : addressService
				.getAddressEntry((Long) entryId);
	}

	public AddressEntry getNewAddressEntry() {
		AddressEntry newEntry = new AddressEntry();
		newEntry.setCategory(getAddressService().getCategories().get(0));
		return newEntry;
	}

}
