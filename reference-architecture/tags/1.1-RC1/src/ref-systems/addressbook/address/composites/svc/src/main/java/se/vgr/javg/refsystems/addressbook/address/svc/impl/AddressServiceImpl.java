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
package se.vgr.javg.refsystems.addressbook.address.svc.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.vgr.javg.refsystems.addressbook.address.svc.AddressService;
import se.vgr.javg.refsystems.addressbook.address.types.AddressEntry;

/**
 * A service that encapsulates an in-memory storage for testing and demo
 * purpose.
 */
public class AddressServiceImpl implements AddressService {
	private static long primaryKeySequence = 0;
	private Map addressEntryMap;
	private List<String> categoryList;

	public AddressServiceImpl() {
		addressEntryMap = new HashMap();
		categoryList = new ArrayList<String>();
		populateWithDefaultData();
	}

	public AddressEntry[] getAddressEntries() {
		return (AddressEntry[]) addressEntryMap.values().toArray(
				new AddressEntry[addressEntryMap.size()]);
	}

	public AddressEntry getAddressEntry(long primaryKey) {
		return (AddressEntry) addressEntryMap.get(new Long(primaryKey));
	}

	public void saveAddressEntry(AddressEntry entry) {
		// provide a primary key if new entry
		if (entry.getEntryId() == 0) {
			entry.setEntryId(getNextPrimaryKey());
		}
		addressEntryMap.put(new Long(entry.getEntryId()), entry);
	}

	public List<String> getCategories() {
		return categoryList;
	}

	public void saveCategory(String category) {
		categoryList.add(category);
	}

	private long getNextPrimaryKey() {
		return ++primaryKeySequence;
	}

	private void populateWithDefaultData() {
		String defaultCategory = "Private";

		// categories
		categoryList.add(defaultCategory);

		addDefaultEntry("Lina Johansson", "Linas v�g", "G�teborg",
				defaultCategory);
		addDefaultEntry("Erik Eriksson", "Eriksgatan", "Alings�s",
				defaultCategory);
		addDefaultEntry("Anders Andersson", "Anders v�g", "Kungsbacka",
				defaultCategory);
	}

	private void addDefaultEntry(String name, String street, String city,
			String category) {
		AddressEntry ae = new AddressEntry();
		ae.setEntryId(getNextPrimaryKey());
		ae.setName(name);
		ae.setStreet(street);
		ae.setCity(city);
		ae.setCategory(category);
		addressEntryMap.put(new Long(ae.getEntryId()), ae);
	}
}
