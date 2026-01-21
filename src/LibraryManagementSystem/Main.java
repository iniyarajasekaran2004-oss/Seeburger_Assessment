package src.LibraryManagementSystem;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        System.out.println("Add book=================================");
        library.addBook(new Book(1004, "Language", "Thowfic", true));
        library.getBooks().forEach(System.out::println);
        System.out.println("Issued Book=================================");
        int bookId = 1002;
        try {
            Operation.issueBook(bookId, library.getBooks());

            System.out.println("Issued Book:");
            library.getBooks().stream()
                    .filter(b -> b.getBookId() == bookId)
                    .forEach(System.out::println);

        } catch (IssueException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Available Books After Issuing:");
        Operation.displayAvailableBooks(library.getBooks());

        System.out.println("Return Book=================================");
        Operation.returnBook(bookId, library.getBooks());

        System.out.println("Returned Book:");
        library.getBooks().stream()
                .filter(b -> b.getBookId() == bookId)
                .forEach(System.out::println);
        System.out.println("Available Books After Returning:");
        Operation.displayAvailableBooks(library.getBooks());
        System.out.println("Search by Author=================================");
        System.out.println("Search by Author (Thowfic):");
        Operation.searchByAuthor("Thowfic", library.getBooks());
        System.out.println("Count Book=================================");
        System.out.println();
        Operation.countBooks(library.getBooks());
    }
}
