package com.example.dslibrarysystem.controller;

import com.example.dslibrarysystem.domain.BookInfo;
import com.example.dslibrarysystem.service.LocalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class MainLibraryController {

    @Autowired
    private LocalBookService lbs;

    @RequestMapping()
    public String index(HttpServletResponse response, Model model) {
        Map books = lbs.getAllBooks();
        model.addAttribute("booksMap", books);
        return response.encodeRedirectURL("/index");
    }

    @RequestMapping("/catalog/{isbn}")
    public String catalog(@PathVariable("isbn") String isbn, Model model) {
        BookInfo bookInfo = lbs.getBookInfo(isbn);
        System.out.println("User want to check book: " + bookInfo.getBookName());
        model.addAttribute("bookName", bookInfo.getBookName());
        model.addAttribute("bookISBN", bookInfo.getISBN());
        model.addAttribute("bookAuthor", bookInfo.getAuthor());
        model.addAttribute("bookPublishYear", bookInfo.getPublishYear());
        model.addAttribute("bookPrice", bookInfo.getPrice());
        return "bookInfo";
    }
}
