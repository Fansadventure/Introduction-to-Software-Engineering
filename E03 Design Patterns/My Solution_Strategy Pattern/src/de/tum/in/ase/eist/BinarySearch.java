package de.tum.in.ase.eist;

import java.util.List;

public class BinarySearch implements SearchStrategy {
    @Override
    public String performSearch(List<PhoneBookEntry> phoneBook, String name) {
        int left = 0;
        int right = phoneBook.size() - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int n = name.compareTo(phoneBook.get(middle).getName());
            if (n == 0) {
                return phoneBook.get(middle).getPhoneNumber();
            }
            if (n < 0) {
                right = middle - 1;
            }
            if (n > 0) {
                left = middle + 1;
            }
        }
        return null;
    }
}
