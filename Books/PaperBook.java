package Books;

import Interfaces.Buyable;
import Interfaces.Shippable;
import Services.ShippingService;

public class PaperBook extends Book implements Buyable, Shippable {
    private int stockQuantity;
    
    public PaperBook(String title, String ISBN, int publicationYear, double price, int stockQuantity) {
        super(title, ISBN, publicationYear, price);
        setStockQuantity(stockQuantity);
    }
    
    public void setStockQuantity(int stockQuantity) {
        if(stockQuantity < 0) {
            throw new IllegalArgumentException("Invalid stock quantity");
        }
        this.stockQuantity = stockQuantity;
    }
    
    public int getStockQuantity() {
        return stockQuantity;
    }
    
    @Override
    public double buy(int quantity, String email, String address) {
        if(quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        if(quantity > stockQuantity) {
            throw new IllegalArgumentException("Not enough stock");
        }
        stockQuantity -= quantity;
        System.out.println("PaperBook " + getTitle() + " has been bought successfully"+"with quantity= " + quantity+"remaining stock= " + stockQuantity);


        shipTo(address);
        return getPrice() * quantity;
    }
    
    @Override
    public void shipTo(String address) {
        if(address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid address");
        }
        System.out.println("sending to shipping service");
        ShippingService.send(this, address);
    }
    
    @Override
    public boolean isBuyable() {
        return stockQuantity > 0;
    }
}
