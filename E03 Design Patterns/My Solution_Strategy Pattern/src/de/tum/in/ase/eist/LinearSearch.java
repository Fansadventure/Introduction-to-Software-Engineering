package de.tum.in.ase.eist;

import java.util.List;

public class LinearSearch implements SearchStrategy {
    @Override
    public String performSearch(List<PhoneBookEntry> phoneBook, String name) {
        for (PhoneBookEntry entry: phoneBook) {
            if (entry.getName().equals(name)) {
                return entry.getPhoneNumber();
            }
        }
        return null;
    }
}
