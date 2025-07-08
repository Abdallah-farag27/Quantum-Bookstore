public class PaperBook extends Book{
    private int stock;

    public PaperBook(String isbn, String title,int publishedYear,double price,int stock){
        super(isbn,title,publishedYear,price);
        this.stock=stock;
    }

    public int getStock() {
        return stock;
    }
    public void reduceStock(int amount){
        this.stock-=amount;
    }


    @Override
    public double buyBook(int quantity){
        if(quantity>this.stock) throw new IllegalArgumentException("Not enough stock");
        reduceStock(quantity);
        return quantity*this.getPrice();
    }
}
