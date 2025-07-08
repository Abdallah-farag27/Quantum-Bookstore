public class ShippingService {

    public static void shipBook(Book book , String address){
        System.out.println("The book ("+book.getTitle()+") is out for Shipping to "+address);
    }
}
