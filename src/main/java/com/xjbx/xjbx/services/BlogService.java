package com.xjbx.xjbx.services;

import com.xjbx.xjbx.enitites.Blog;
import com.xjbx.xjbx.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public List<Blog> findAllBlogs() {
        List<Blog> blogs = new ArrayList<>();
        blogRepository.findAll().forEach(blogs::add);
        return blogs;
    }
}
