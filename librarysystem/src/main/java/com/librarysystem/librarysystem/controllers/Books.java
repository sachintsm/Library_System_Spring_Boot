package com.librarysystem.librarysystem.controllers;

import com.librarysystem.librarysystem.domain.BooksDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.librarysystem.librarysystem.services.BookServices;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Books {

    @Autowired
    private BookServices bookServices;

    //get all books details
    @GetMapping("/getall")
    public List<BooksDomain> allBooks(){

        return bookServices.findAllBooks();
    }

    //Add book data to the table
    @PostMapping("/addbook")
    public String addBook(@RequestBody BooksDomain bookData){

        return bookServices.saveBook(bookData);
    }
}
