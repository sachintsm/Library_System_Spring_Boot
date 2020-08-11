package com.librarysystem.librarysystem.services.impl;

import com.librarysystem.librarysystem.domain.BooksDomain;
import com.librarysystem.librarysystem.domain.UserDomain;
import com.librarysystem.librarysystem.repositories.BooksRepository;
import com.librarysystem.librarysystem.repositories.UserRepository;
import com.librarysystem.librarysystem.services.UserServices;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
    private UserRepository userRepository;
	
	@Override
    public List<UserDomain> findAllUsers() {
        List<UserDomain> allusers = userRepository.findAll();
        return allusers;
    }
	
	@Override
    public Optional<UserDomain> findById(Integer id) {
        return userRepository.findById(id);
    }
	
	@Override
    public UserDomain save(UserDomain userdata)
    {
        return userRepository.save(userdata);
    }
	
	@Override
	public UserDomain findOne(Integer id) {
		return userRepository.findById(id).get();
	}
	
	@Override
    public Map<String, String> deleteById(Integer id) {
        String msg;
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            msg = "Successfully Deleted!";
        }else{
            msg = "Deleted Not Successful!";
        }
        return Collections.singletonMap("msg", msg);
    }

}
