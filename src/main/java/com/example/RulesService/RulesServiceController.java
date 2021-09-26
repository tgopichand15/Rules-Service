package com.example.RulesService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RulesServiceController {

    @Controller
    @Requestmapping("/issues_list")
    public List<ExistingIssues> validEntries(){

        //process data from DB and finally create final entries for hashmap values hostname and issues name
        @Autowired
        private SaveDataClientTest savedataclienttest;

        //get existing issues from Db

        List<ExistingIssues> issues=savedataclienttest.getexistingIssues();

        return issues;
    }
}
