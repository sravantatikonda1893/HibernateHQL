package test;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteClient {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		String hql="delet Student where id=55";
		Query q=s.createQuery(hql);
		q.executeUpdate();
		t.commit();
		s.close();
		sf.close();
		System.out.println("Data deletion success");
	}

}
