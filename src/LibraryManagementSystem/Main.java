package src.LibraryManagementSystem;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        System.out.println("Add book=================================");
        library.addBook(new Book(1004, "Language", "Thowfic", true));
        library.getBooks().forEach(System.out::println);
        //Issued Book
        try {
            Operation.issueBook(1002, library.getBooks());
        } catch (IssueException e) {
            System.out.println(e.getMessage());
        }
        //Return Book
        Operation.returnBook(1001, library.getBooks());

        System.out.println("Available Books==================================");
        Operation.displayAvailableBooks(library.getBooks());
        System.out.println("Search by Author=================================");
        System.out.println("Author (Hema):");
        Operation.searchByAuthor("Hema", library.getBooks());
        System.out.println("Count=================================");
        Operation.countBooks(library.getBooks());
    }
}
