import java.time.LocalDate;

public abstract class Book {
    private String title;
    private String isbn;
    private int year;
    private double price;

    public  Book(String isbn, String title,int year,double price){
        this.isbn=isbn;
        this.title=title;
        this.year=year;
        this.price=price;
    }

    public Boolean isOutdated(int maxYears){
        int currentYear= LocalDate.now().getYear();
        return (currentYear-this.year)>maxYears;
    }

    public abstract double buyBook(int quantity)throws IllegalArgumentException;

    public String getISBN() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
