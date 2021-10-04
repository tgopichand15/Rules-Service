package com.example.client;

import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;

public class FetchDataClient {



       public static int getCount(String issueName,String teamName){
           try(Session session = HibernateUtil.getSessionFactory().openSession()) {
               Query query = session.createQuery("FROM ExistingIssue i WHERE i.issueName=:issueName and i.teamName=:teamName");
               query.setParameter("issueName", IssueName);
               query.setParameter("teamName",teamName);
               session.beginTransaction();
               session.getTransaction().commit();
               return ((ExistingIssue)query.uniqueResult()).count;
           } catch (HibernateException e) {
               e.printStackTrace();
           }
	    }


	    public static ArrayList<ExistingIssue> getAllExistingIssues(){
            try(Session session = HibernateUtil.getSessionFactory().openSession()) {
                Query query = session.createQuery("select * FROM ExistingIssue ");
                session.beginTransaction();
                ArrayList<ExistingIssue> a=query.list();
                session.getTransaction().commit();
                return a;
            } catch (HibernateException e) {
                e.printStackTrace();
            }



        }


    }
