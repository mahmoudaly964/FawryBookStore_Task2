package Services;

import Books.PaperBook;

public class ShippingService {
    public static void send(PaperBook book, String address) {
        System.out.println("PaperBook " + book.getTitle() + " has been shipped to " + address + " successfully");
    }
    
}
