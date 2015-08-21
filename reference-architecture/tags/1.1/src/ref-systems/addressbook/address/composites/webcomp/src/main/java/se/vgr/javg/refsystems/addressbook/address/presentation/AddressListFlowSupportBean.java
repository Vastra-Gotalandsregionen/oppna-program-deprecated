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

import se.vgr.javg.refsystems.addressbook.address.svc.AddressService;
import se.vgr.javg.refsystems.addressbook.address.types.AddressEntry;

/**
 * Fetch list of all addresses.
 */
public class AddressListFlowSupportBean {
	private AddressService addressService;

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	/**
	 * Uses integration service to access service layer.
	 */
	public List<AddressEntry> getEntries() {
		AddressEntry[] entries = getAddressService().getAddressEntries();
		List<AddressEntry> result = new ArrayList<AddressEntry>();
		for (AddressEntry entry : entries) {
			result.add(entry);
		}
		return result;
	}
}
