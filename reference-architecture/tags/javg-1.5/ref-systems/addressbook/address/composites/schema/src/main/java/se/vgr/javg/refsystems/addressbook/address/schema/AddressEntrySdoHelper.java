/* Copyright 2009 Västa Götalandsregionen

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
package se.vgr.javg.refsystems.addressbook.address.schema;

import java.util.ArrayList;
import java.util.List;

import se.vgr.core.schema.addressentry.v1.AddressEntryListType;
import se.vgr.core.schema.addressentry.v1.AddressEntryType;
import se.vgr.javg.refsystems.addressbook.address.types.AddressEntry;

/**
 * HelperClass for conversion between SDO representation of AddressEntry and the
 * common type POJO counterpart.
 */
public abstract class AddressEntrySdoHelper {

	/**
	 * Prevent instantiation by sub-classing
	 */
	AddressEntrySdoHelper() {
	}

	/**
	 * Builds an SDO AddressEntryType from an AddressEntry
	 * 
	 * @param entry
	 * @return AddressEntryType
	 */
	public static AddressEntryType toAddressEntryType(AddressEntry entry) {
		AddressEntryType entrySDO = new AddressEntryType();
		entrySDO.setEntryId(entry.getEntryId());
		entrySDO.setCategory(entry.getCategory());
		entrySDO.setCity(entry.getCity());
		entrySDO.setName(entry.getName());
		entrySDO.setStreet(entry.getStreet());
		return entrySDO;
	}

	/**
	 * Builds an AddressEntry from an SDO counterparty
	 * 
	 * @param sdoEntry
	 * @return
	 */
	public static AddressEntry fromAddressEntryType(AddressEntryType sdoEntry) {
		AddressEntry newEntry = new AddressEntry();
		newEntry.setEntryId(sdoEntry.getEntryId());
		newEntry.setCategory(sdoEntry.getCategory());
		newEntry.setCity(sdoEntry.getCity());
		newEntry.setName(sdoEntry.getName());
		newEntry.setStreet(sdoEntry.getStreet());
		return newEntry;
	}

	/**
	 * Builds a list of address entries from an AddressEntryList
	 * 
	 * @param list
	 * @return
	 */
	public static List<AddressEntry> fromAddressEntryListType(
			AddressEntryListType list) {

		ArrayList<AddressEntry> returnType = new ArrayList<AddressEntry>();
		for (AddressEntryType sdo : list.getAddressEntry()) {
			AddressEntry entry = AddressEntrySdoHelper
					.fromAddressEntryType(sdo);
			returnType.add(entry);
		}
		return returnType;
	}

	/**
	 * Builds an AddressEntryListType from a list of list of address entries
	 * 
	 * @param addressEntryList
	 * @return
	 */
	public static AddressEntryListType toAddressEntryListType(
			List<AddressEntry> addressEntryList) {
		AddressEntryListType returnType = new AddressEntryListType();
		for (AddressEntry entry : addressEntryList) {
			AddressEntryType entrySDO = AddressEntrySdoHelper
					.toAddressEntryType(entry);
			returnType.getAddressEntry().add(entrySDO);
		}
		return returnType;
	}
}
