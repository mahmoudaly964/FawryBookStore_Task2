package Services;

import Books.EBook;

public class EmailService {
    public static void send(EBook book, String email) {
        System.out.println("EBook " + book.getTitle() + " has been sent to " + email + " successfully");
    }
}
