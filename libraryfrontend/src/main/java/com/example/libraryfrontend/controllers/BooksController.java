package com.example.libraryfrontend.controllers;

import com.example.libraryfrontend.entity.Book;
import com.example.libraryfrontend.entity.IssueBook;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class BooksController {

    //view all the books in the library
    @GetMapping("/")
    public ModelAndView getHome() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8081/api/getall";

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response.getBody());
        } else {
            System.out.println("Error");
        }

        ModelAndView modelAndView = new ModelAndView("Home");
        modelAndView.addObject("Book", response.getBody());
        return modelAndView;
    }

    //delete books
    @RequestMapping("/addBook")
    public RedirectView addBook(Book book) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/api/addbook";
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url, book, Object.class);

//        System.out.println(responseEntity);
        return new RedirectView("/");
    }
    
    @RequestMapping("/deleteBook/{id}")
    public RedirectView deleteBook(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/api/delete/" + id;
        restTemplate.delete(url);

        System.out.println("This is me" + url);
        return new RedirectView("/");
    }
    
    @RequestMapping("getBook/{id}")
    public ModelAndView getBook(@PathVariable String id ) {
        RestTemplate restTemplate = new RestTemplate();
        
        String url = "http://localhost:8081/api/getBook/" + id;

        Book book = restTemplate.getForObject(url, Book.class);
        
        System.out.print("this is me again" +book);
    	
        
        ModelAndView modelAndView = new ModelAndView("AddBook");
        modelAndView.addObject("Book", book);
    	return modelAndView;
    }
    
    
    @RequestMapping("/addMe")
    public String AddBook() {
        System.out.println("addBook");
        return "AddBook";
    }

    @RequestMapping("/cancel")
    public RedirectView cancelAddBook() {
        return new RedirectView("/");
    }

    //render issue book page
    @RequestMapping("/issueBook")
    public String IssueVook(){
        return "IssueBook";
    }

    //submit issue book
    @RequestMapping("/issueBookClick")
    public RedirectView issueBookClick(IssueBook issueBook) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(issueBook);
        String url = "http://localhost:8081/api/issuebook";
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url, issueBook, Object.class);
        System.out.println(responseEntity);
        return new RedirectView("/issueBook");
    }

    //get issue book list
    @GetMapping("/issueBook")
    public ModelAndView getIssues(){
        System.out.println("Call Now");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8081/api/getIssues";

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response.getBody());
        } else {
            System.out.println("Error");
        }

        ModelAndView modelAndView = new ModelAndView("IssueBook");
        modelAndView.addObject("IssueBook", response.getBody());
        return modelAndView;
    }

    //delete issue book
    @RequestMapping("/deleteIssue/{id}")
    public RedirectView deleteIsse(@PathVariable String id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/deleteIssue/"+id;
        restTemplate.delete(url);

        System.out.println("Delete Issue");
        return new RedirectView("/issueBook");
    }
}
