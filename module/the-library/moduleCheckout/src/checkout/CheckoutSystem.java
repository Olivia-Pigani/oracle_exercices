package checkout;

import book.Book;

import java.util.ArrayList;
import java.util.List;

public class CheckoutSystem {


    private final List<Book> borrowedBookList = new ArrayList<>();

    public void borrowBook(Book book) {
        borrowedBookList.add(book);
        System.out.println("the book " + book + " has been borrowed");
    }

    public void returnBook(Book book) {
        borrowedBookList.removeIf(borrowedBookList::contains);
        System.out.println("the book " + book + " has been returned");
    }


}