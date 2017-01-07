package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Employee;

public class Client {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Employee e=new Employee(1, "sravan", "s@gmail.com", 200);
		Employee e1=new Employee(2, "sravani", "sra@gmail.com", 600);
		Employee e2=new Employee(3, "srujan", "sru@gmail.com", 300);
		s.save(e);
		s.save(e1);
		s.save(e2);
		t.commit();
		s.close();
		sf.close();
 	}

}
