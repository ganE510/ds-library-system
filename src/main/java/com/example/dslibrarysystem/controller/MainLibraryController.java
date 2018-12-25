package com.example.dslibrarysystem.controller;

import com.example.dslibrarysystem.service.LocalBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
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
    public String catalog(@PathVariable("isbn") String isbn) {
        return null;
    }
}
