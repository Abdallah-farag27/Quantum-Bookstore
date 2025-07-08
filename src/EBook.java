public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title,int publishedYear,double price,String fileType){
        super(isbn,title,publishedYear,price);
        this.fileType=fileType;
    }

    public String getFileType(){
        return this.fileType;
    }

    @Override
    public double buyBook(int quantity) throws IllegalArgumentException {
        return quantity*this.getPrice();
    }
}
