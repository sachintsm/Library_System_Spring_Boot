package com.example.libraryfrontend.controllers;

import com.example.libraryfrontend.entity.Book;
import com.example.libraryfrontend.entity.IssueBook;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

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

    //    add books
    @RequestMapping("/addBook")
    public RedirectView addBook(Book book) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/addbook";
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url, book, Object.class);
        return new RedirectView("/");
    }

    //    delete specific book
    @RequestMapping("/deleteBook/{id}")
    public RedirectView deleteBook(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/delete/" + id;
        restTemplate.delete(url);
        return new RedirectView("/");
    }

    // get book from Id
    @RequestMapping("/getBook")
    public ModelAndView getBook(@RequestParam(value = "id") int bookId) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.print(bookId);
        String url = "http://localhost:8081/api/getBook/" + bookId;
        Object object = restTemplate.getForObject(url, Object.class);
        ModelAndView modelAndView = new ModelAndView("EditBook");
        modelAndView.addObject("Book", object);
        return modelAndView;
    }

    //get book from Id
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam(value = "id") int bookId) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.print(bookId);
        String url = "http://localhost:8081/api/getBook/" + bookId;
        Object object = restTemplate.getForObject(url, Object.class);
        ModelAndView modelAndView = new ModelAndView("Search");
        modelAndView.addObject("Book", object);
        return modelAndView;
    }

    //Update book
    @RequestMapping("/updateBook")
    public RedirectView updateBook(Book book, HttpServletRequest req) {
        String bookId = req.getParameter("id");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/update/" + bookId;
        restTemplate.put(url, book);
        return new RedirectView("/");
    }

    //Route to Add book page
    @RequestMapping("/addMe")
    public String AddBook() {
        System.out.println("addBook");
        return "AddBook";
    }

    //route to ome page
    @RequestMapping("/cancel")
    public RedirectView cancelAddBook() {
        return new RedirectView("/");
    }

    //render issue book page
    @RequestMapping("/issueBook")
    public String IssueVook() {
        return "IssueBook";
    }
    
  //render user page
    @RequestMapping("/userPage")
    public String userPage(){
        return "UserPage";
    }

    //submit issue book
    @RequestMapping("/issueBookClick")
    public RedirectView issueBookClick(IssueBook issueBook) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/issuebook";
        restTemplate.postForEntity(url, issueBook, Object.class);
        return new RedirectView("/issueBook");
    }

    //get issue book list
    @GetMapping("/issueBook")
    public ModelAndView getIssues() {
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

    //delete a issue book from the list
    @RequestMapping("/deleteIssue/{id}")
    public RedirectView deleteIssue(@PathVariable String id) {
        System.out.println(id);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8081/api/deleteIssue/" + id;
        restTemplate.delete(url);
        return new RedirectView("/issueBook");
    }

    //open edit issue page
    @RequestMapping("/editIssue")
    public ModelAndView getIssue(@RequestParam(value = "id") int issueId) {
        System.out.println(issueId);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/getIssue/" + issueId;
        Object object = restTemplate.getForObject(url, Object.class);
        ModelAndView modelAndView = new ModelAndView("EditIssue");
        modelAndView.addObject("Issue", object);
        return modelAndView;
    }

    //    Update Issue
    @RequestMapping("/updateIssue")
    public RedirectView updateIssue(IssueBook issueBook, HttpServletRequest req) {
        String issueId = req.getParameter("id");
        System.out.println(issueBook);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/updateIssue/" + issueId;
        restTemplate.put(url, issueBook);
        return new RedirectView("/issueBook");
    }

    //route to Book Issues page
    @RequestMapping("/cancelIssue")
    public RedirectView cancelIssue() {
        return new RedirectView("/issueBook");
    }

}
