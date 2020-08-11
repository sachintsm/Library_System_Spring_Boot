package com.librarysystem.librarysystem.repositories;

import com.librarysystem.librarysystem.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDomain, Integer> {

}
