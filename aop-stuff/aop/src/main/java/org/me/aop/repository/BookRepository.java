package org.me.aop.repository;

import org.me.aop.exception.BookNotInDatabaseException;
import org.me.aop.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAllBooks();

    void deleteBookById(int id) throws BookNotInDatabaseException;

    void saveABook(Book book);

}
