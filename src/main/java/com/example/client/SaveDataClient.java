package com.example.client;

import com.example.RulesService.entities.ExistingIssues;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.*;


public class SaveDataClient {

	/*public static void main(String[] args) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			List<ExistingIssues> l=getexistingIssues();
			for(int i=0;i<l.size();i++){
				System.out.println(l.get(i).toString());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}


	}*/

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getIssue());
		System.out.println("Employee is created  with Id::"+id);
		session.getTransaction().commit();
		
	}


	private static List<ExistingIssues> getexistingIssues(){

		List<ExistingIssues> issuesList=new ArrayList<ExistingIssues>();
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
	
	private static ExistingIssues getIssue(){
		ExistingIssues issues=new ExistingIssues();
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
			session.getTransaction().commit()

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
				session.getTransaction().commit()
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
}
