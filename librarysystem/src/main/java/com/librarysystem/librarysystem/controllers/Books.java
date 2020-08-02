package com.librarysystem.librarysystem.controllers;

import com.librarysystem.librarysystem.domain.BooksDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.librarysystem.librarysystem.services.BookServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Books {

    @Autowired
    private BookServices bookServices;


    //get all books details
    @GetMapping("/getall")
    public List<BooksDomain> allBooks() {
        return bookServices.findAllBooks();
    }

    //Add book data to the table
    @PostMapping("/addbook")
    public BooksDomain addBook(@RequestBody BooksDomain bookData) {
        return bookServices.save(bookData);
    }

    //delete book data
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        System.out.println("Hello");
        return bookServices.deleteById(id);
    }

    //find by id
    @GetMapping("/getBook/{id}")
    public Optional<BooksDomain> getBookById(@PathVariable Integer id) {
        return bookServices.findById(id);
    }
}
