package com.librarysystem.librarysystem.repositories;

import com.librarysystem.librarysystem.domain.IssueDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<IssueDomain,Integer> {
}
