public class MailService {
    public static void MailBook(Book book, String email){
        System.out.println("The book ("+book.getTitle()+") was sent to "+email);
    }
}
