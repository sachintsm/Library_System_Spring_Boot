package com.librarysystem.librarysystem.services.impl;


import com.librarysystem.librarysystem.domain.IssueDomain;
import com.librarysystem.librarysystem.repositories.IssueRepository;
import com.librarysystem.librarysystem.services.IssueServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class IssueServiceImpl implements IssueServices {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public IssueDomain save(IssueDomain issueData) {
        return issueRepository.save(issueData);
    }

    @Override
    public List<IssueDomain> findAllIssues(){
        return issueRepository.findAll();
    }

    @Override
    public Map<String, String> deleteById(Integer id){
        String msg;
        if(issueRepository.findById(id).isPresent()){
            issueRepository.deleteById(id);
            msg = "Successfully Deleted!";
        }else{
            msg = "Deleted Not Successful!";
        }
        return Collections.singletonMap("msg", msg);
    }


}
