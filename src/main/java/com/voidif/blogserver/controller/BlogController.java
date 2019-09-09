package com.voidif.blogserver.controller;

import com.voidif.blogserver.model.BlogDescription;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @RequestMapping("/api/blog")
    public List<BlogDescription> retrieveBlogList() {
        return null;
    }
}
