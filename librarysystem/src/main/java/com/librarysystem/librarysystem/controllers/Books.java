package com.librarysystem.librarysystem.controllers;

import com.librarysystem.librarysystem.domain.BooksDomain;
import com.librarysystem.librarysystem.domain.IssueDomain;
import com.librarysystem.librarysystem.services.IssueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.librarysystem.librarysystem.services.BookServices;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class Books {

    @Autowired
    private BookServices bookServices;

    @Autowired
    private IssueServices issueServices;

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
    public Optional<BooksDomain> getBookById(@PathVariable Integer id) {
        return bookServices.findById(id);
    }

    //add issue book data
    @PostMapping("/issuebook")
    public IssueDomain issueBook(@RequestBody IssueDomain issueData){
        System.out.println(issueData);
        System.out.println(issueServices.save(issueData));
        return issueServices.save(issueData);
    }

    //get all book issues
    @GetMapping("/getIssues")
    public List<IssueDomain> getAllIssues(){
        return issueServices.findAllIssues();
    }

    //delete issue
    @DeleteMapping("/deleteIssue/{id}")
    public Map<String, String> deleteIssue(@PathVariable Integer id) {
        return issueServices.deleteById(id);
//        return issueData;
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<BooksDomain> updateBook(@PathVariable Integer id,  @Valid @RequestBody BooksDomain bookDetails){
    	BooksDomain book = bookServices.findOne(id);
		if(book == null) {
			return ResponseEntity.notFound().build();
		}
		book.setName(bookDetails.getName());
		book.setAuthor(bookDetails.getAuthor());
		book.setStock(bookDetails.getStock());
		BooksDomain updateBook = bookServices.save(book);
		return ResponseEntity.ok().body(updateBook);
    }
}
