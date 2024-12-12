package org.me.aop.repository;

import org.me.aop.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAllBooks();

    void deleteBookById(int id);

    void saveABook(Book book);

}
