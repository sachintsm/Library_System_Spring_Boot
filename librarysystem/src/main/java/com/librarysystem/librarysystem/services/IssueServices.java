package com.librarysystem.librarysystem.services;

import com.librarysystem.librarysystem.domain.IssueDomain;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IssueServices {
    IssueDomain save(IssueDomain issueData);

    List<IssueDomain> findAllIssues();

    Map<String, String> deleteById(Integer id);

    Optional<IssueDomain> findById(Integer id);

    IssueDomain findOne(Integer id);
}
