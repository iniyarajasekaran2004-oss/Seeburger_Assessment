package src.LibraryManagementSystem;

import java.util.Optional;
import java.util.Set;

public class Operation {

    // Issue Book
    public static void issueBook(int bookId, Set<Book> books) throws IssueException {
        Optional<Book> bookOpt = books.stream()
                .filter(b -> b.getBookId() == bookId)
                .findFirst();

        if (!bookOpt.isPresent()) {
            throw new IssueException("Book not found");
        }

        Book book = bookOpt.get();
        if (!book.isAvailable()) {
            throw new IssueException("Book already issued");
        }

        book.setAvailable(false);
    }

    // Return Book
    public static void returnBook(int bookId, Set<Book> books) {
        books.stream()
                .filter(b -> b.getBookId() == bookId)
                .findFirst()
                .ifPresent(b -> b.setAvailable(true));
    }

    // Search by Author
    public static void searchByAuthor(String author, Set<Book> books) {
        books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .forEach(System.out::println);
    }

    // Display Available Books
    public static void displayAvailableBooks(Set<Book> books) {
        books.stream()
                .filter(Book::isAvailable)
                .sorted()
                .forEach(System.out::println);
    }

    // Count total & issued books
    public static void countBooks(Set<Book> books) {
        long total = books.size();
        long issued = books.stream().filter(b -> !b.isAvailable()).count();

        System.out.println("Total Books: " + total);
        System.out.println("Issued Books: " + issued);
    }
}
