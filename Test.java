import Bookstore.BookStore;
import Books.*;

public class Test {
    public static void main(String[] args) {
        BookStore store = new BookStore();
        //adding different types of books
        store.addBook(new PaperBook("Harry Potter","225" , 2001, 150.0, 10));
        store.addBook(new EBook("Lord of the rings","411" , 1990, 250.0,  "pdf"));
        store.addBook(new EBook( "Atomic Habits","119", 2005, 100.0,  "pdf"));
        store.addBook(new DemoBook( "Green Earth","789", 2018, 0.0));
        //remove outdated books
        var books=store.removeOutdatedBooks(30);
        
        // trying buy paper book
        try {
            double price = store.buyBook("225", 2, "mahmoud@gmail.com","october");
            System.out.println("total price= " + price);
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        }
        // trying buy EBook
         try {
            double price = store.buyBook("119", 1, "mahmoud@gmail.com","october");
            System.out.println("total price= " + price);
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        }
        // trying buy demo book
        try {
            double price = store.buyBook("789",1,"","" );
        }catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        }
        // try buying book that doesn't exist
        try {
            double price = store.buyBook("333", 2, "mahmoud@gmail.com","october");
            System.out.println("total price= " + price);
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        }
        // try buy paper book with quantity greater than the stock
        try {
            double price = store.buyBook("225", 11, "mahmoud@gmail.com","october");
            System.out.println("total price= " + price);
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        }
        // try buy paper book with quantity equal to what is in the stock
        try {
            // stock now have 8 books of harry potter as we buy 2 books above
            double price = store.buyBook("225", 8, "mahmoud@gmail.com","october");
            System.out.println("total price= " + price);
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        }
}
}
