package com.xjbx.xjbx.controllers;

import com.xjbx.xjbx.enitites.Blog;
import com.xjbx.xjbx.enitites.User;
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

    @Autowired
    BlogService blogService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/blogs")
    public void addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/blogs")
    public List<Blog> findAllBlogs() {
        return blogService.findAllBlogs();
    }
}
