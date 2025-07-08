# FawryBookStore - Task 2

## Overview
FawryBookStore is a Java-based bookstore management system that demonstrates object-oriented programming principles including inheritance, polymorphism, interfaces, and exception handling. The system manages different types of books (Paper Books, E-Books, and Demo Books) with their respective purchasing and delivery mechanisms.

## Features

### Book Types
- **Paper Books**: Physical books with stock management and shipping
- **E-Books**: Digital books delivered via email
- **Demo Books**: Non-purchasable books for preview purposes

### Core Functionality
- Add books to inventory with ISBN validation
- Remove outdated books based on publication year
- Purchase books with different delivery methods
- Stock management for paper books
- Email delivery for digital books
- Comprehensive error handling


### Running the Project

1. **Compile the project:**
   ```bash
    javac *.java
   ```

2. **Run the test class:**
   ```bash
   java Test
   ```

## Class Descriptions

### Abstract Classes
- **Book**: Base class containing common properties (title, ISBN, publication year, price)

### Concrete Classes
- **PaperBook**: Implements `Buyable` and `Shippable` interfaces
- **EBook**: Implements `Buyable` and `Emailable` interfaces  
- **DemoBook**: Non-purchasable book for demonstration

### Interfaces
- **Buyable**: Defines purchase behavior
- **Emailable**: Defines email delivery behavior
- **Shippable**: Defines physical shipping behavior

### Services
- **EmailService**: Handles email delivery for e-books
- **ShippingService**: Handles physical shipping for paper books

### Main Classes
- **BookStore**: Manages inventory and purchase operations
- **Test**: provide test cases 

## Contributing

This project is part of Fawry's training program. Feel free to submit issues and enhancement requests.

## License

This project is created for educational purposes as part of Fawry's software development training.