package test;


import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.OldStudent;

public class HQLTabletoTableCopy {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		String hql="insert into NewStudent(id,name,email,address)select s.id,s.name,s.email,s.address from OldStudent s";
		s.createQuery(hql);
		t.commit();
		s.close();
		sf.close();
		System.out.println("Data insertion success");
	}

}


//In  HQL, insert can only do from one table to other table copy. It cannot insert data from the user