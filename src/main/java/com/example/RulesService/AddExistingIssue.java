package com.example.RulesService;

import com.example.entities.ExistingIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
//import com.example.RulesService.SaveDatataClient;

import java.util.List;


@Component("Test1")
@ComponentScan(basePackages={"com.example.RulesService"})
public class AddExistingIssue {

    SaveDataClient k;

    @Autowired
    public AddExistingIssue(SaveDataClient s){
        this.k=s;
    }

    public AddExistingIssue(){

    }


    public SaveDataClient getK() {
        return k;
    }

    public void setK(SaveDataClient k) {
        this.k = k;
    }

    public void addIssue(ExistingIssue e){
        if(e!=null) {
            k.addExistingIssue(e);
        }
        else{
            System.out.println("Issues to be inserted are empty or Db object not created correctly");
        }
    }
    public void addMultipleIssues(List<ExistingIssue> l){

        if(l.size()>0 && l!=null){
            k.addExistingIssues(l);
        }
        else{
            System.out.println("no issues provided as input which are to be added to DB please provide correct input or db object not created correctly");
        }
    }



    //System.out.println("savedataclient outside is " + savedataclient);
    //public static void main(String[] args){

        /*ExistingIssue i=new ExistingIssue();
        i.setIssueName("CPU");
        i.setTeamName("Wintel");
        i.setCount(5);*/



      //  AddExistingIssue a=new AddExistingIssue();

       //System.out.println("object is "+a.getK());













        //System.out.println("s is "+t);
     //  System.out.println("savedataclient is " + savedataclient);

        //System.out.println(a);

        //a.addIssue(i,savedataclient);
        //AddExistingIssue a=new AddExistingIssue();
        //a.test();

   // }

    }

