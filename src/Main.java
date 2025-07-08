import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bookstore bookStore = new Bookstore();

        Book paperBook = new PaperBook("PaperBook 1", "The man", 1984, 300, 3);
        Book eBook = new EBook("EBOOK 1", "How to Train ur Dragons", 2005, 150, "PDF");
        Book ShowcaseBook = new ShowcaseBook("ShowcaseBook 1", "Showcase Book", 2022, 0);

        System.out.println("######### TEST CASE 1 ###########");
        System.out.println("Test Description: Try to buy a book with a non-existent ISBN.");
        System.out.println("Expected Result: Exception should be thrown for book not found.\n");

        try {
            bookStore.buySingleBook("dummy", 1, "farag@yahoo.com", "giza");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("############################\n\n");

        System.out.println("######### TEST CASE 2 ###########");
        System.out.println("Test Description: Add three books (paper, ebook, demo), then remove outdated books (older than 10 years).");
        System.out.println("Expected Result: Paper and Ebook are removed. Only ShowcaseBook remains in inventory.\n");

        try {
            bookStore.addBook(paperBook);
            bookStore.addBook(eBook);
            bookStore.addBook(ShowcaseBook);

            List<Book> removedBooks = bookStore.removeOutdatedBooks(10);

            System.out.println("Removed Outdated Books:");
            for (Book book : removedBooks) {
                System.out.println("ISBN: " + book.getISBN() + "\tTitle: " + book.getTitle());
            }

            System.out.println("\nRemaining Books in Inventory:");
            bookStore.printInventory();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("############################\n\n");

        System.out.println("######### TEST CASE 3 ###########");
        System.out.println("Test Description: Add back the paper and ebook, then attempt to buy both successfully.");
        System.out.println("Also attempt to buy the demo book which should fail.");
        System.out.println("Expected Result: paperBook (2x300=600), ebook (4x150=600) are bought. Demo book fails to buy.\n");

        try {
            bookStore.addBook(paperBook);
            bookStore.addBook(eBook);

            double paperAmountPaid = bookStore.buySingleBook("PaperBook 1", 2, "farag@yahoo.com", "Dokki");
            System.out.println("Paid amount for paperBook: " + paperAmountPaid);

            double eAmountPaid = bookStore.buySingleBook("EBOOK 1", 4, "farag@yahoo.com", "Dokki");
            System.out.println("Paid amount for eBook: " + eAmountPaid);

            double demoAmountPaid = bookStore.buySingleBook("ShowcaseBook 1", 7, "farag@yahoo.com", "Dokki");
            System.out.println("Paid amount for ShowcaseBook: " + demoAmountPaid);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("############################\n\n");

        System.out.println("######### TEST CASE 4 ###########");
        System.out.println("Test Description: Try to buy 2 copies of paperBook, but only 1 is left in stock.");
        System.out.println("Expected Result: Exception should be thrown for insufficient stock.\n");

        try {
            bookStore.buySingleBook("PaperBook 1", 2, "farag@yahoo.com", "Dokki");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());

        }

        System.out.println("############################\n\n");

        System.out.println("######### TEST CASE 5 ###########");
        System.out.println("Test Description: Try to add a book with an ISBN that already exists.");
        System.out.println("Expected Result: Exception should be thrown for duplicate ISBN.\n");

        try {
            Book duplicateISBNBook = new PaperBook("PaperBook 1", "A different title", 1900, 300, 1);
            bookStore.addBook(duplicateISBNBook);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("############################\n\n");


    }
}
