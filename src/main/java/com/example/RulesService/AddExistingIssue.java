package com.example.RulesService;

import com.example.client.FetchDataClient;
import com.example.entities.ExistingIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.example.client.SaveDataClient;
import java.util.List;

@Component
@ComponentScan("com.example.RulesService")
public class AddExistingIssue {


    public void addIssue(ExistingIssue e, SaveDataClient s){
        if(s!=null && e!=null) {
            s.addExistingIssue(e);
        }

        else{
            System.out.println("Issues to be inserted are empty or Db object not created correctly");
        }
    }




    public void addMultipleIssues(List<ExistingIssue> l, SaveDataClient s1){

        if(l.size()>0 && s1!=null){
            s1.addExistingIssues(l);
        }

        else{
            System.out.println("no issues provided as input which are to be added to DB please provide correct input or db object not created correctly");
        }

    }






    @Autowired
    static SaveDataClient s;


    //System.out.println("savedataclient outside is " + savedataclient);


    public static void main(String[] args){

        /*ExistingIssue i=new ExistingIssue();
        i.setIssueName("CPU");
        i.setTeamName("Wintel");
        i.setCount(5);*/




        //System.out.println("i is "+i);
        System.out.println("savedataclient is "+s);

        //System.out.println(a);

        //a.addIssue(i,savedataclient);
    }

    }

