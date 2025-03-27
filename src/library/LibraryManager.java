package library;
import java.io.*;
import java.util.*;

public class LibraryManager {
    private static final String FILE_NAME = "BOOKS.dat";
    private List<Book> books;

    public LibraryManager() {
        books = loadBooks();
    }

    // 📌 Add a Book
    public void addBook(Book book) {
        books.add(book);
        saveBooks();
        System.out.println("✅ Book added successfully!");
    }

    // 📌 View All Books
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("⚠ No books available.");
            return;
        }
        books.forEach(System.out::println);
    }

    // 📌 Search Book by ID or Title
    public Book searchBook(String query) {
        for (Book book : books) {
            if (book.getBookID().equalsIgnoreCase(query) || book.getTitle().equalsIgnoreCase(query)) {
                return book;
            }
        }
        return null;
    }

    // 📌 Update Book Details
    public boolean updateBook(String bookID, String newTitle, String newAuthor, String newGenre, String newStatus) {
        for (Book book : books) {
            if (book.getBookID().equalsIgnoreCase(bookID)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                book.setGenre(newGenre);
                book.setAvailabilityStatus(newStatus);
                saveBooks();
                System.out.println("✅ Book updated successfully!");
                return true;
            }
        }
        System.out.println("⚠ Book not found.");
        return false;
    }

    // 📌 Delete a Book
    public boolean deleteBook(String bookID) {
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getBookID().equalsIgnoreCase(bookID)) {
                iterator.remove();
                saveBooks();
                System.out.println("✅ Book deleted successfully!");
                return true;
            }
        }
        System.out.println("⚠ Book not found.");
        return false;
    }

    // 📌 Save Books to FILE (Serialization)
    private void saveBooks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("❌ Error saving books: " + e.getMessage());
        }
    }

    // 📌 Load Books from FILE (Deserialization)
    private List<Book> loadBooks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠ Error loading books: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
