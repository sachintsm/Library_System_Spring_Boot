package com.librarysystem.librarysystem.repositories;

import com.librarysystem.librarysystem.domain.BooksDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<BooksDomain, Integer> {
}
