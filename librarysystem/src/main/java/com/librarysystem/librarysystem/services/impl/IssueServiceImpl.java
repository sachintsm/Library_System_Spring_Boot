package com.librarysystem.librarysystem.services.impl;


import com.librarysystem.librarysystem.domain.IssueDomain;
import com.librarysystem.librarysystem.repositories.IssueRepository;
import com.librarysystem.librarysystem.services.IssueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceImpl implements IssueServices {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public IssueDomain save(IssueDomain issueData) {
        return issueRepository.save(issueData);
    }


}
