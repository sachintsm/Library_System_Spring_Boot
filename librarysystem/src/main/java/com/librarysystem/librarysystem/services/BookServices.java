package com.librarysystem.librarysystem.services;

import com.librarysystem.librarysystem.domain.BooksDomain;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookServices {

    List<BooksDomain> findAllBooks();

	BooksDomain save(BooksDomain bookdata);

    Map<String, String> deleteById(Integer id);


    Optional<BooksDomain> findById(Integer id);
   
    BooksDomain findOne(Integer id);
    
}
