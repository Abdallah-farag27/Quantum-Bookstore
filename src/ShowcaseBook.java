public class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title,int publishedYear,double price){
        super(isbn,title,publishedYear,price);
    }

    @Override
    public double buyBook(int quantity) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Cant buy a Showcase Book");
    }
}
