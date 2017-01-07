package test;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_Single_Row_Select {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		String hql="from Employee where id=1";
		Query q=s.createQuery(hql);
		Employee e=(Employee) q.uniqueResult();
		System.out.println(e.getName());
		System.out.println(e.getEmail());
		System.out.println(e.getSalary());
		System.out.println(e.getId());
		t.commit();
		s.close();
		sf.close();
 	}

}
