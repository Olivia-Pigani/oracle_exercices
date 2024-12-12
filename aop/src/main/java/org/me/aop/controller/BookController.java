package org.me.aop.controller;

import org.me.aop.model.Book;
import org.me.aop.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId){
        return new ResponseEntity<>(bookService.deleteABook(bookId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addABook(@RequestBody Book newBook){
        return new ResponseEntity<>(bookService.postABook(newBook),HttpStatus.CREATED);
    }
}
