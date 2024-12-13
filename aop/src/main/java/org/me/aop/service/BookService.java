package org.me.aop.service;

import org.me.aop.exception.BookNotInDatabaseException;
import org.me.aop.model.Book;
import org.me.aop.repository.InMemoryBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final InMemoryBookRepository repository;


    public BookService(InMemoryBookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() throws InterruptedException, BookNotInDatabaseException {
        Thread.sleep(100); //add artificial time
        List<Book> bookList =  repository.getAllBooks();

        if (bookList.isEmpty()){
            throw new BookNotInDatabaseException("there is no book here !");
        }

        return bookList;
    }


    public String deleteABook(int id) throws BookNotInDatabaseException {
        repository.deleteBookById(id);
        return "book with id " + id + " is deleted from library";
    }

    public String postABook(Book newBook) {
        repository.saveABook(newBook);
        return "the new book " + newBook.getTitle() + " of " + newBook.getAuthor() + " has been added !";
    }
}
