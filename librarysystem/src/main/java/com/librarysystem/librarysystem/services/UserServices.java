package com.librarysystem.librarysystem.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.librarysystem.librarysystem.domain.UserDomain;

public interface UserServices {

	public List<UserDomain> findAllUsers();
	
	Optional<UserDomain> findById(Integer id);
	
	UserDomain save(UserDomain userdata);
	
	UserDomain findOne(Integer id);
	
    Map<String, String> deleteById(Integer id);

}
