package com.main.v11t1;

import java.util.ArrayList;

public class ContactStorage {
    private static ContactStorage instance = null;
    private ArrayList<Contact> contacts;

    private ContactStorage() {
        contacts = new ArrayList<>();
    }

    public static ContactStorage getInstance() {
        if (instance == null) {
            instance = new ContactStorage();
        }
        return instance;
    }

    public ArrayList<Contact> getContacts() { return contacts; }
    public void addContact(Contact contact) { contacts.add(contact); }
    public void removeContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    public void sortAlphabetically() {
        contacts.sort((c1, c2) -> c1.getFullName().compareToIgnoreCase(c2.getFullName()));
    }

    public void sortByGroup() {
        contacts.sort((c1, c2) -> {

            if (c1.getContactGroup().equals("Työ") && !c2.getContactGroup().equals("Työ")) {
                return -1;
            }

            if (c2.getContactGroup().equals("Työ") && !c1.getContactGroup().equals("Työ")) {
                return 1;
            }

            return c1.getFullName().compareToIgnoreCase(c2.getFullName());
        });
    }
}