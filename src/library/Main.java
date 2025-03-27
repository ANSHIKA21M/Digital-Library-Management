package library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📚 DIGITAL LIBRARY MANAGEMENT SYSTEM 📚");
            System.out.println("1️⃣ Add a Book");
            System.out.println("2️⃣ View All Books");
            System.out.println("3️⃣ Search Book (by ID or Title)");
            System.out.println("4️⃣ Update Book Details");
            System.out.println("5️⃣ Delete a Book");
            System.out.println("6️⃣ Exit");
            System.out.print("👉 Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // 📌 Add a Book
                    System.out.print("📖 Enter Book ID: ");
                    String bookID = scanner.nextLine();
                    System.out.print("📖 Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("👤 Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("📂 Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("📌 Enter Availability (Available / Checked Out): ");
                    String status = scanner.nextLine();

                    if (!status.equalsIgnoreCase("Available") && !status.equalsIgnoreCase("Checked Out")) {
                        System.out.println("❌ Invalid Availability Status!");
                        break;
                    }

                    Book newBook = new Book(bookID, title, author, genre, status);
                    libraryManager.addBook(newBook);
                    break;

                case 2: // 📌 View All Books
                    libraryManager.viewBooks();
                    break;

                case 3: // 📌 Search a Book
                    System.out.print("🔍 Enter Book ID or Title: ");
                    String query = scanner.nextLine();
                    Book foundBook = libraryManager.searchBook(query);
                    if (foundBook != null) {
                        System.out.println("✅ Book Found: " + foundBook);
                    } else {
                        System.out.println("⚠ Book not found!");
                    }
                    break;

                case 4: // 📌 Update Book
                    System.out.print("✏ Enter Book ID to update: ");
                    String updateID = scanner.nextLine();
                    System.out.print("📖 Enter New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("👤 Enter New Author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("📂 Enter New Genre: ");
                    String newGenre = scanner.nextLine();
                    System.out.print("📌 Enter New Availability (Available / Checked Out): ");
                    String newStatus = scanner.nextLine();

                    if (!newStatus.equalsIgnoreCase("Available") && !newStatus.equalsIgnoreCase("Checked Out")) {
                        System.out.println("❌ Invalid Availability Status!");
                        break;
                    }

                    libraryManager.updateBook(updateID, newTitle, newAuthor, newGenre, newStatus);
                    break;

                case 5: // 📌 Delete a Book
                    System.out.print("🗑 Enter Book ID to delete: ");
                    String deleteID = scanner.nextLine();
                    libraryManager.deleteBook(deleteID);
                    break;

                case 6: // 📌 Exit
                    System.out.println("🚀 Exiting the system... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}
