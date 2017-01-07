package test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.OldStudent;

public class UpdateClient {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		OldStudent os1=new OldStudent(12, "sravan", "s@gmail.com", "hyd");
		OldStudent os2=new OldStudent(13, "srujan", "sru@gmail.com", "nzb");
		OldStudent os3=new OldStudent(14, "sravani", "sra@gmail.com", "harm");
		OldStudent os4=new OldStudent(15, "srivani", "sri@gmail.com", "kmr");
		s.save(os1);
		s.save(os2);
		s.save(os3);
		s.save(os4);
		t.commit();
		s.close();
		sf.close();
		System.out.println("Data insertion success");
	}

}
