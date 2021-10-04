package com.example.client;

import com.example.entities.ExistingIssue;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchDataClient {



       public static int getCount(String issueName,String teamName){
           try(Session session = HibernateUtil.getSessionFactory().openSession()) {
               Query query = session.createQuery("FROM ExistingIssue i WHERE i.issueName=:issueName and i.teamName=:teamName");
               query.setParameter("issueName", issueName);
               query.setParameter("teamName",teamName);
               session.beginTransaction();
               session.getTransaction().commit();
               return ((ExistingIssue)query.uniqueResult()).count;
           } catch (HibernateException e) {
               e.printStackTrace();
           }

           return -1;
	    }


	    public static List<ExistingIssue> getAllExistingIssues(){
            try(Session session = HibernateUtil.getSessionFactory().openSession()) {
                Query query = session.createQuery("select * FROM ExistingIssue ");
                session.beginTransaction();
                List<ExistingIssue> a=query.list();
                session.getTransaction().commit();
                return a;
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        return null;
        }


    }
