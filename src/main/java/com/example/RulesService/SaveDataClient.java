package com.example.RulesService;

import com.example.entities.ExistingIssue;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.*;



@Component("Test")
@ComponentScan(basePackages={"com.example.RulesService"})
public class SaveDataClient {


	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getIssue());
		System.out.println("Employee is created  with Id::"+id);
		session.getTransaction().commit();
		
	}


	private static List<ExistingIssue> getexistingIssues(){

		List<ExistingIssue> issuesList=new ArrayList<ExistingIssue>();
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "select * from existing_issues";
			Query query = session.createSQLQuery(hql);
			issuesList = query.list();
			return issuesList;
			// no ClassCastException here

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return issuesList;

	}
	
	private static ExistingIssue getIssue(){
		ExistingIssue issues=new ExistingIssue();
		issues.setIssueName("MemoryUnix");
		issues.setTeamName("Unix");
		issues.setCount(5);
		return issues;
	}


	public static void addExistingIssue(ExistingIssue i){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			int id=(Integer)session.save(i);
			System.out.println("Existing Issue is created  with Id::"+id);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	public static void addExistingIssues(List<ExistingIssue> l){
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			for(ExistingIssue e : l) {
				int id = (Integer) session.save(e);
				System.out.println("Existing Issue is created  with Id::" + id);
				session.getTransaction().commit();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	public void Test(){
		System.out.println("Savedataclient object created");
	}

	@Override
	public String toString() {
		return "SaveDataClient{}";
	}
}
