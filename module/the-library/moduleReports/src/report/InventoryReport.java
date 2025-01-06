package report;

import book.Book;

import java.util.List;

public class InventoryReport {
    public void generateReport(List<Book> bookInventory) {
        System.out.println(" the report : the inventory is looking like this : " + bookInventory);
    }
}
