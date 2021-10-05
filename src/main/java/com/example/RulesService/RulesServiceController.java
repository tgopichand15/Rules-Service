package com.example.RulesService;

import com.example.client.FetchDataClient;
import com.example.entities.ExistingIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RulesServiceController {

    FetchDataClient fetchdataclient;

    @Autowired
    public RulesServiceController(FetchDataClient f){
        this.fetchdataclient=f;
    }

    public RulesServiceController(){

    }

    @RequestMapping("/issues_list")
    public List<ExistingIssue> validEntries(){

        //process data from DB and finally create final entries for hashmap values hostname and issues name

        //get existing issues from Db

        List<ExistingIssue> issues=fetchdataclient.getAllExistingIssues();

        return issues;
    }
}
