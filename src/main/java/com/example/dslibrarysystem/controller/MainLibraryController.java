package com.example.dslibrarysystem.controller;

import com.example.dslibrarysystem.domain.BookInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MainLibraryController {
    @RequestMapping()
    public String index(HttpServletResponse response, Model model) {
        return response.encodeRedirectURL("/index"); }

    @RequestMapping("/index")
    public String home(Model model) {
        return "index"; }
}
