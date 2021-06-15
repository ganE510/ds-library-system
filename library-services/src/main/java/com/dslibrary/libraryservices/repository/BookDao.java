package com.dslibrary.libraryservices.repository;

import com.dslibrary.libraryservices.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDao {
    private static final String HASH_KEY = "Book";

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public Book saveBook(Book book) {
        template.opsForHash().put(HASH_KEY, book.getIsbn(), book);
        return book;
    }

    public List<Book> findAllBooks() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Book findBookByIsbn(String isbn) {
        return (Book) template.opsForHash().get(HASH_KEY, isbn);
    }

    public String deleteBook(String isbn){
        template.opsForHash().delete(HASH_KEY, isbn);
        return "Book " + isbn + " removed.";
    }
}
