package com.xjbx.xjbx.controllers;

import com.xjbx.xjbx.enitites.Blog;
import com.xjbx.xjbx.services.BlogService;
import com.xjbx.xjbx.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    private final BlogService blogService;
    private final UserService userService;

    @Autowired
    public BlogController(UserService userService, BlogService blogService) {
        this.userService = userService;
        this.blogService = blogService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/blogs")
    public void addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/blogs")
    public List<Blog> findAllBlogs() {
        return blogService.findAllBlogs();
    }
}
