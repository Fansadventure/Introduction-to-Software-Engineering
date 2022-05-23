package de.tum.in.ase.eist;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private List<PhoneBookEntry> phoneBook = new ArrayList<>();
    private SearchStrategy searchAlgorithm;

    public boolean isPhoneBookSorted() {
        for (int i = 1; i < phoneBook.size() - 1; i++) {
            if (phoneBook.get(i - 1).getName().compareTo(phoneBook.get(i).getName()) > 0) {
                return false;
            }
        }
        return true;
    }

    public String search(String name) {
        return searchAlgorithm.performSearch(phoneBook, name);
    }

    // getters and setters:
    public List<PhoneBookEntry> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(List<PhoneBookEntry> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public SearchStrategy getSearchAlgorithm() {
        return searchAlgorithm;
    }

    public void setSearchAlgorithm(SearchStrategy searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }
}
