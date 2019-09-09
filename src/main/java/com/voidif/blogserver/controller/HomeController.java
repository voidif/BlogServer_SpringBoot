package com.voidif.blogserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private static final String REDIRECT_HOMEPAGE = "redirect:/index.html";
    @RequestMapping({"", "/"})
    public String getHomePage() {
        return REDIRECT_HOMEPAGE;
    }
}
