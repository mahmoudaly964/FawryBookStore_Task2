package Bookstore;

import Books.*;
import Interfaces.Buyable;
import java.time.Year;
import java.util.*;

public class BookStore {
    private Map<String, Book> inventory = new HashMap<>();
    
    public void addBook(Book book) {
        inventory.put(book.getISBN(), book);
    }
    
    public Book getBook(String ISBN) {
        return inventory.get(ISBN);
    }
    
    public List<Book> removeOutdatedBooks(int outdatedYear) {
        int currentYear = Year.now().getValue();
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> iterator = inventory.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();
            if (currentYear - book.getPublicationYear() > outdatedYear || book.getPublicationYear() > currentYear) {
                iterator.remove();
                removedBooks.add(book);
                System.out.println("remove " + book.getTitle() + " because it is outdated");
            }
        }
        return removedBooks;
    }
    
    public double buyBook(String ISBN, int quantity, String email, String address) {
        Book book = inventory.get(ISBN);
        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }
        if (!book.isBuyable()) {
            throw new IllegalArgumentException("you can't buy demo books");
        }
        return ((Buyable) book).buy(quantity, email, address);
    }
}
