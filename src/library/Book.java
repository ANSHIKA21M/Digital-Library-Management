package library;
import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String bookID;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;

    public Book(String bookID, String title, String author, String genre, String availabilityStatus) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public String getAvailabilityStatus() { return availabilityStatus; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setAvailabilityStatus(String availabilityStatus) { this.availabilityStatus = availabilityStatus; }

    @Override
    public String toString() {
        return "Book ID: " + bookID + "\nTitle: " + title + "\nAuthor: " + author +
                "\nGenre: " + genre + "\nAvailability: " + availabilityStatus + "\n";
    }
}
