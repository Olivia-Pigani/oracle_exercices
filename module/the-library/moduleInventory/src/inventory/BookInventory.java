package inventory;

import book.Book;

import java.util.ArrayList;
import java.util.List;

public class BookInventory {

    private final List<Book> bookInventory = new ArrayList<>();

    public void pickBook(Book book) {
        bookInventory.add(book);
        System.out.println("the book " + book + " has been picked into the inventory");
    }

    public void removeBook(Book book) {
        bookInventory.removeIf(bookInventory::contains);
        System.out.println("the book " + book + " has been returned into the inventory");
    }

    public void getBookInventory() {
        System.out.println(bookInventory);
    }
}
