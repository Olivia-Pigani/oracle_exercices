package org.me.aop.service;

import org.me.aop.model.Book;
import org.me.aop.repository.InMemoryBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final InMemoryBookRepository repository;


    public BookService(InMemoryBookRepository repository) {
        this.repository = repository;
    }


    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }


    public String deleteABook(int id) {
        repository.deleteBookById(id);
        return "book with id " + id + " is deleted from library";
    }

    public String postABook(Book newBook) {
        repository.saveABook(newBook);
        return "the new book " + newBook.getTitle() + " of " + newBook.getAuthor() + " has been added !";
    }
}
