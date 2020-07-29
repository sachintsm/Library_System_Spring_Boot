package com.librarysystem.librarysystem.services.impl;

import com.librarysystem.librarysystem.domain.BooksDomain;
import com.librarysystem.librarysystem.repositories.BooksRepository;
import com.librarysystem.librarysystem.services.BookServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookServices {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<BooksDomain> findAllBooks() {
        List<BooksDomain> allbooks = booksRepository.findAll();
        return allbooks;
    }

    @Override
    public BooksDomain save(BooksDomain bookdata) {
        return  booksRepository.save(bookdata);
    }
    

}
