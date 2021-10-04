package com.example.RulesService;

import com.example.client.SaveDataClient;
import com.example.entities.ExistingIssue;

import java.util.List;

public class AddExistingIssue {


    public void addIssue(ExistingIssue e, SaveDataClient s){
        if(s!=null && e!=null) {
            s.addExistingIssue(e);
        }

        else{
            System.out.println("Issues to be inserted are empty or Db object not created correctly")
        }
    }




    public void addMultipleIssues(List<ExisitingIssue> l, SaveDataClient s1){

        if(l.size()>0 && s1!=null){
            s1.addExistingIssues(l);
        }

        else{
            System.out.println("no issues provided as input which are to be added to DB please provide correct input or db object not created correctly");
        }

    }
}
