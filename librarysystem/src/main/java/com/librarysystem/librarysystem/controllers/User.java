package com.librarysystem.librarysystem.controllers;

import com.librarysystem.librarysystem.domain.BooksDomain;
import com.librarysystem.librarysystem.domain.UserDomain;
import com.librarysystem.librarysystem.services.IssueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.librarysystem.librarysystem.services.UserServices;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class User {

    @Autowired
    private UserServices userServices;

    //get all users details
    @GetMapping("/getallUsers")
    public List<UserDomain> allUsers() {
        return userServices.findAllUsers();
    }
    
    //get user by the id
    @GetMapping("/getUser/{id}")
    public Optional<UserDomain> getBookById(@PathVariable Integer id) {
        return userServices.findById(id);
    }
    
    @PutMapping("updateOneUser/{id}")
    public ResponseEntity<UserDomain> updateOneUser(@PathVariable Integer id,  @Valid @RequestBody UserDomain userDetails){
    	UserDomain user = userServices.findOne(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		user.setLname(userDetails.getLname());
		user.setFname(userDetails.getFname());
		user.setAddress(userDetails.getAddress());
		UserDomain updateUser = userServices.save(user);
		return ResponseEntity.ok().body(updateUser);
    }
    
  //delete book data
    @DeleteMapping("/deleteOneUser/{id}")
    @ResponseBody
    public Map<String, String> deleteBook(@PathVariable Integer id) {
        return userServices.deleteById(id);
    }

}
