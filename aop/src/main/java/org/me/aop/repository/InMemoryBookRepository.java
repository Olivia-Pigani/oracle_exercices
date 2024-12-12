package org.me.aop.repository;

import org.me.aop.model.Book;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public class InMemoryBookRepository implements BookRepository{

    List<Book> bookList = Arrays.asList(
            new Book("harry potter", LocalDate.of(1995,2,14), "jk rowling"),
            new Book("one piece", LocalDate.of(1994,2,14), "oda"),
            new Book("got", LocalDate.of(1985,2,14), "je sais plus")
    );

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public void deleteBookById(int id) {
        bookList.removeIf(book -> book.getId() == id);
    }

    @Override
    public void saveABook(Book book) {
        bookList.add(book);
    }
}
