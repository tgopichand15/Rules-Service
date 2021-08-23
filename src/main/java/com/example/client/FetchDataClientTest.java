package com.example.client;

import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class FetchDataClientTest {

	public static void main(String[] args) {
		/*Issues issues = null;
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	issues = session.get(Issues.class, 1);
	    	System.out.println(issues);
		} catch (HibernateException e) {
			e.printStackTrace();
		}*/

       public static Issues getCount(String Hostname,String issue){
            Query query = session.createQuery("SELECT count FROM Issues i WHERE i.host=:Hostname and i.issueType=:issue");
            query.setParameter("Hostname", Hostname);
            return query.uniqueResult();
	    }


        private static void updateEmployeeById(Session session){
            Employee e=session.get(Employee.class,1);

            if(e==null){
                System.out.println("employed with provided id does not exist");
            }
            else{
                e.setSalary(50000);
                session.beginTransaction();

                session.update(e);

                session.getTransaction().commit();
                System.out.println(e);
            }
        }








    }
