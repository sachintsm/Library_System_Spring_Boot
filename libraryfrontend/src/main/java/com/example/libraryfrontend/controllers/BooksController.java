package com.example.libraryfrontend.controllers;

import com.example.libraryfrontend.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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


//    add books
    @RequestMapping("/addBook")
    public RedirectView addBook(Book book) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/api/addbook";
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(url, book, Object.class);

        System.out.println(responseEntity);
        return new RedirectView("/");
    }
    
//    delete specific book
    @RequestMapping("/deleteBook/{id}")
    public RedirectView deleteBook(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/api/delete/" + id;
        restTemplate.delete(url);

//        System.out.println("This is me" + url);
        
        return new RedirectView("/");
    }
    
    
    
//    get book from Id
    @RequestMapping("/getBook")
    public ModelAndView getBook( @RequestParam(value="id") int bookId ) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.print(bookId);
        
        String url = "http://localhost:8081/api/getBook/" + bookId;

        Object object = restTemplate.getForObject(url, Object.class);
        
//        System.out.print("this is me again" + object);
    	    
        
        ModelAndView modelAndView = new ModelAndView("EditBook");
        modelAndView.addObject("Book", object);
        
    	return modelAndView; 
    }
    
//    Update book
    @RequestMapping("/updateBook")
    public RedirectView updateBook(Book book, HttpServletRequest req ) {
    	
    	  String bookId = req.getParameter("id");
//    	System.out.print(bookId);
    	  RestTemplate restTemplate = new RestTemplate();

          String url = "http://localhost:8081/api/update/"+ bookId;
           restTemplate.put(url, book);
           
          return new RedirectView("/");
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

}
