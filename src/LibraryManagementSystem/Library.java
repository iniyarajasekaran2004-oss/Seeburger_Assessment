package src.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library {
    private Set<Book> books = new HashSet<>();

    public Library() {
        books.add(new Book(1001, "Life", "Hema", false));
        books.add(new Book(1002, "History", "Aswin", true));
        books.add(new Book(1003, "World", "Nandha", true));
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }
}



