package com.dslibrary.libraryservices.controller;

import com.dslibrary.libraryservices.entity.Book;
import com.dslibrary.libraryservices.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @PostMapping
    public Book save(@RequestBody Book book){
        return bookDao.saveBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookDao.findAllBooks();
    }

    @GetMapping("/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn){
        return bookDao.findBookByIsbn(isbn);
    }

    @DeleteMapping("/{isbn}")
    public String deleteBook(@PathVariable String isbn){
        return bookDao.deleteBook(isbn);
    }
}
