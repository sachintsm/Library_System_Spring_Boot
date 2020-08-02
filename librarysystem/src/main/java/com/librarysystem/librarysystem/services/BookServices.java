package com.librarysystem.librarysystem.services;

import com.librarysystem.librarysystem.domain.BooksDomain;

import java.util.List;
import java.util.Map;

public interface BookServices {

    List<BooksDomain> findAllBooks();

	BooksDomain save(BooksDomain bookdata);

    Map<String, String> deleteById(Integer id);

    String findById(Integer id);
}
