package Books;

import Interfaces.Buyable;
import Interfaces.Emailable;
import Services.EmailService;

public class EBook extends Book implements Buyable, Emailable {
    // assume ebook don't have stock as they are digital products
    String fileType;
    
    public EBook(String title, String ISBN, int publicationYear, double price, String fileType) {
        super(title, ISBN, publicationYear, price);
        setFileType(fileType);
    }
    
    public void setFileType(String fileType) {
        if(fileType == null) {
            throw new IllegalArgumentException("invalid file type");
        }
        this.fileType = fileType;
    }
    
    @Override
    public double buy(int quantity, String email, String address) {
        if(quantity != 1) {
            throw new IllegalArgumentException("you can also buy 1 copy of the ebook");
        }
        // assume ebook don't have stock as they are digital products
        System.out.println("EBook " + getTitle() + " has been bought successfully");
        sendTo(email);
        return getPrice();
    }
    
    @Override
    public void sendTo(String email) {
        if(email == null || !email.contains("@")) {
            throw new IllegalArgumentException("invalid email address");
        }
        System.out.println("sending to email service");
        EmailService.send(this, email);
    }
    
    @Override
    public boolean isBuyable() {
        return true;
    }
}
