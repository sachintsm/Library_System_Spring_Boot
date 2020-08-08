package com.librarysystem.librarysystem.services;

import com.librarysystem.librarysystem.domain.IssueDomain;

import java.util.List;
import java.util.Map;

public interface IssueServices {
    IssueDomain save(IssueDomain issueData);

    List<IssueDomain> findAllIssues();


}
