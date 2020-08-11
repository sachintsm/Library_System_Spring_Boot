package com.example.libraryfrontend.controllers;

import com.example.libraryfrontend.entity.Book;
import com.example.libraryfrontend.entity.User;

import com.example.libraryfrontend.entity.IssueBook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)

public class UserController {
	
	//view all the books in the library
    @GetMapping("/userPage")
    public ModelAndView userPage() {
    	RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://localhost:8081/api/getallUsers";

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println(response.getBody());
        } else {
            System.out.println("Error");
        }

        ModelAndView modelAndView = new ModelAndView("UserPage");
        modelAndView.addObject("User", response.getBody());
        return modelAndView;
    }

//  get book from Id
   @RequestMapping("/getUser")
   public ModelAndView getUser( @RequestParam(value="id") int userId ) {
      RestTemplate restTemplate = new RestTemplate();
      System.out.print("this is the user id " + userId + "  ");
      
      String url = "http://localhost:8081/api/getUser/" + userId;

      Object object = restTemplate.getForObject(url, Object.class);
      
//      System.out.print("this is me again" + object);
  	    
      
      ModelAndView modelAndView = new ModelAndView("EditUser");
      modelAndView.addObject("User", object);
      
  	return modelAndView; 
  }
   
// Update book
   @RequestMapping("/updateUser")
   public RedirectView updateUser(User user, HttpServletRequest req ) {
 	
 	  String userId = req.getParameter("id");
 	  System.out.print(userId);
 	  RestTemplate restTemplate = new RestTemplate();

       String url = "http://localhost:8081/api/updateOneUser/"+ userId;
        restTemplate.put(url, user);
        
       return new RedirectView("/userPage");
 }
   
// delete a user
 @RequestMapping("/deleteUser/{id}")
 public RedirectView deleteUser(@PathVariable String id) {
	 RestTemplate restTemplate = new RestTemplate();

     String url = "http://localhost:8081/api/deleteOneUser/" + id;
     restTemplate.delete(url);

     
     return new RedirectView("/userPage");
 }
}
