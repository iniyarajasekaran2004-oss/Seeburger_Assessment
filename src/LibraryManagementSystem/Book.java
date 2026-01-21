package src.LibraryManagementSystem;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final int bookId;
    private boolean available;
    private final String title;
    private final String author;

    Book(int bookId, String title, String author,  boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }
public void setAvailable(boolean available){
        this.available=available;

}
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                " bookId=" + bookId +
                ", title='" + title + '\'' +
                ",author='" + author + '\'' +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.bookId, o.bookId);
    }
}
