package Books;

public class DemoBook extends Book {
    
    public DemoBook(String title, String ISBN, int publicationYear, double price) {
        super(title, ISBN, publicationYear, price);
    }
    
    @Override
    public boolean isBuyable() {
        return false;
    }
}
