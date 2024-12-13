package org.me.aop.repository;

import org.me.aop.exception.BookNotInDatabaseException;
import org.me.aop.model.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class InMemoryBookRepository implements BookRepository {

    //filled list
//    List<Book> bookList = Arrays.asList(
//            new Book("harry potter", LocalDate.of(1995, 2, 14), "jk rowling"),
//            new Book("one piece", LocalDate.of(1994, 2, 14), "oda"),
//            new Book("got", LocalDate.of(1985, 2, 14), "je sais plus")
//    );

    //empty list to test exception BookNotInDatabaseException
    List<Book> bookList = List.of();

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public void deleteBookById(int id) throws BookNotInDatabaseException {

        boolean isBookInDatabase = bookList.stream()
                .anyMatch(book -> book.getId() == id);

        if (!isBookInDatabase){
            throw new BookNotInDatabaseException("the book in not in the database");
        }

        bookList = bookList.stream()
                .filter(book -> book.getId() != id)
                .toList();
    }

    @Override
    public void saveABook(Book book) {
        bookList = Stream.concat(bookList.stream(), Stream.of(book))
                .toList();
    }
}
