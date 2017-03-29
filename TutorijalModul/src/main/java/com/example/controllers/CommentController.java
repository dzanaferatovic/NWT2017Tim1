package com.example.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.models.Comment;

public class CommentController {

	
	 final AtomicLong id = new AtomicLong();

	    @RequestMapping("/coms")
	    public Comment tagovi(@RequestParam(value="name") String name) {
	        return new Comment(id.incrementAndGet(), name);
	    }

}
