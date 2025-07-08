package Books;

public abstract class Book {
    protected String title;
    protected String ISBN;
    protected int publicationYear;
    protected double price;

    public Book(String title, String ISBN, int publicationYear, double price) {
        setTitle(title);
        setISBN(ISBN);
        setPublicationYear(publicationYear);
        setPrice(price);
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getISBN() {
        return ISBN;
    }
    
    public int getPublicationYear() {
        return publicationYear;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public void setPublicationYear(int publicationYear) {
        if(publicationYear < 0 || publicationYear > 2025) {
            throw new IllegalArgumentException("Invalid publication year");
        }
        this.publicationYear = publicationYear;
    }
    
    public void setPrice(double price) {
        if(price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        this.price = price;
    }
    
    public abstract boolean isBuyable();
}
