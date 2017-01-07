package test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class HQL_SelectAll {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		String hql="from Employee ";
		Query q=s.createQuery(hql);
		List<Employee> list=(List<Employee>)q.list();
		for(Employee e:list){

			System.out.println(" ------------------------- --------------------" );
			System.out.println(e.getName());
			System.out.println(e.getEmail());
			System.out.println(e.getSalary());
			System.out.println(e.getId());
		}

		t.commit();
		s.close();
		sf.close();
	}

}
