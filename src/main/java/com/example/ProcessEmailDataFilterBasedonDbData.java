package com.example;

import org.springframework.beans.factory.annotation.Autowired;

public class ProcessEmailDataFilterBasedonDbData {

    //check frequenceies from DB and process data from EmailProcessingService

    @Autowired
    private FetchDetailsfromEmailProcessingService fetchdetails;



    @Autowired
    private FetchDataClientTest fetchdatafromDb;

    //calling Db service

    HashMap<String,Integer> hm=fetchdetails.fetchUnprocessedData(GmailClient);



    HashMap<String,String> fetchProcessedIssue(FetchDetailsfromEmailProcessingService fetchdetails,FetchDataClientTest fetchdatafromDb,HashMap<String,String> hm){



        HashMap<String,String> issueDetails=new HashMap<String,String>();


        for (String i : hm.keySet()) {
            String[] input = i.split(" ");
            String hostname = input[0];
            String issue = input[1];

            int count = fetchdatafromDb.getCount(hostname, issue);

            if (hm.get(i) >= count) {

                issueDetails.put(hostname, issue);

            }
        }

        return issueDetails;
    }





}
