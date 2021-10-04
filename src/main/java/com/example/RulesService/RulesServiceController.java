package com.example.RulesService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RulesServiceController {

    @Controller
    @Requestmapping("/issues_list")
    public List<ExistingIssues> validEntries(FetchDataClient fetchdataclient){

        //process data from DB and finally create final entries for hashmap values hostname and issues name

        //get existing issues from Db

        List<ExistingIssues> issues=fetchdataclient.getAllExistingIssues();

        return issues;
    }
}
