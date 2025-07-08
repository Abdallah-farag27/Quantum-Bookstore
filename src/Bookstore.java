import java.util.*;

public class Bookstore {
    private Map<String,Book> inventory;

    public Bookstore(){
        inventory=new HashMap<>();
    }

    public void addBook(Book book){
        if(inventory.containsKey(book.getISBN())) throw new IllegalArgumentException("A book with this ISBN already exist");
        inventory.put(book.getISBN(), book);
    }

    public List<Book> removeOutdatedBooks(int maxYears){
        List<Book> ans = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> it = inventory.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Book> entry = it.next();
            Book book = entry.getValue();
            if (book.isOutdated(maxYears)) {
                ans.add(book);
                it.remove();
            }
        }

        return ans;
    }

    public void printInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Quantum book store: Inventory is empty.");
            return;
        }

        System.out.println("Quantum book store: Current Inventory:");
        for (Book book : inventory.values()) {
            System.out.println("ISBN: " + book.getISBN()
                    + " | Title: " + book.getTitle()
                    + " | Year: " + book.getYear()
                    + " | Price: " + book.getPrice()
                    + " | Type: " + book.getClass().getSimpleName()
            );
        }
    }


    public double buySingleBook(String isbn,int quantity,String email,String address) throws IllegalArgumentException{
        if(!inventory.containsKey(isbn)) throw new IllegalArgumentException("Required Book not found");
        Book book=inventory.get(isbn);
        double price;
        try{
            price=book.buyBook(quantity);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        if(book instanceof PaperBook){
            ShippingService.shipBook(book,address);
        }
        if(book instanceof EBook){
            MailService.MailBook(book,email);
        }
        return price;
    }
}
