package com.librarysystem.librarysystem.controllers;

import com.librarysystem.librarysystem.domain.BooksDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.librarysystem.librarysystem.services.BookServices;

import java.util.List;
import java.util.Map;

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
        System.out.println(bookServices.save(bookData));
        return bookServices.save(bookData);
    }

    //delete book data
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Map<String, String> deleteBook(@PathVariable Integer id) {
        return bookServices.deleteById(id);
    }

    //find by id
    @GetMapping("/getBook/{id}")
    public String getBookById(@PathVariable Integer id) {
        return bookServices.findById(id);
    }
}
