package com.example;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
package com.example.EmailProcessingservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.netflix.appinfo.InstanceInfo;
import org.example
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;


public class FetchDetailsfromEmailProcessingService {


        @Autowired
        private RestTemplate restTemplate;

        @Autowired
        private EurekaClient eurekaClient;


        @Value("${client.name}")
        private String clientname;


        public HashMap<String,Integer> fetchUnprocessedData(String clientname) {
            Application application = eurekaClient.getApplication(EmailProcessingServiceApplication);
            InstanceInfo instanceInfo = application.getInstances().get(0);
            String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + clientname ;
            System.out.println("URL" + url);
            HashMap<String,Integer> hm = restTemplate.getForObject(url, EmailProcessingServiceApplication.class);
            System.out.println("RESPONSE " + hm);
            return hm;
        }

    }


