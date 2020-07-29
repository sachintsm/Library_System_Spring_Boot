package com.librarysystem.librarysystem.services;

import com.librarysystem.librarysystem.domain.BooksDomain;

import java.util.List;

public interface BookServices {

    List<BooksDomain> findAllBooks();

	BooksDomain save(BooksDomain bookdata);
	
   
}
