package test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_Aggregate {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		String hql="select avg(salary) from Employee";
		Query q=s.createQuery(hql);
		double average= (double) q.uniqueResult();
		System.out.println("avg is:"+average	);
		t.commit();
		s.close();
		sf.close();
	}

}
