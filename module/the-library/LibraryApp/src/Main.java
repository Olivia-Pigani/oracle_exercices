import inventory.BookInventory;

import book.Book;

public class Main {
    public static void main(String[] args) {

        BookInventory bookInventory = new BookInventory();

        bookInventory.pickBook(
                new Book("jk rowling", "harry potter")
        );

        bookInventory.getBookInventory();

    }
}