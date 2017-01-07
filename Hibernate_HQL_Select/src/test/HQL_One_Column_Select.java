package test;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQL_One_Column_Select {


	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		String hql="select name from Employee";
		Query q=s.createQuery(hql);
		List<String> list= q.list();
		for(String name:list){
			System.out.println(name);

		}
		t.commit();
		s.close();
		sf.close();
	}

}
