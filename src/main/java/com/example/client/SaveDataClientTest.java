package com.example.client;

import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.example.entities.ExistingIssues;


public class SaveDataClientTest {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	createEmployee(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getIssue());
		System.out.println("Employee is created  with Id::"+id);
		session.getTransaction().commit();
		
	}


	private static void updateEmployee(Session session){
		
	}
	
	private static ExistingIssues getIssue(){
		ExistingIssues issues=new ExistingIssues();
		issues.setIssueName("CPU");
		issues.setTeamName("Windows");
		issues.setCount(10);
		return issues;
	}
}
