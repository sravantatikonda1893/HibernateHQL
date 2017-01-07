package test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_Two_Column_Select {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		String hql="select name,email from Employee";
		Query q=s.createQuery(hql);
//	As the above result will return rows of names and email could be stored in a list
		List<Object> list= q.list();
		for(Object o:list)
		{
			Object arr[]=(Object[])o;
			System.out.println(arr[0]);
			System.out.println(arr[1]);
		}
		t.commit();
		s.close();
		sf.close();
 	}

}
