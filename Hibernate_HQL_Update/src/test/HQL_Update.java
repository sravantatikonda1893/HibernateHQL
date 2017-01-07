package test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class HQL_Update {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
//		We can even update primary key fields too, which is not possible using update() and merge() ddl operations
		String hql="update Student set name='sravan',email='sru@gmail.com' where id=111";
		org.hibernate.Query q= s.createQuery(hql);
//		for ddl(create,update,delete) commands we should executeUpdate() method
		int i= q.executeUpdate();
		t.commit();
		System.out.println(i);
		s.close();
		sf.close();
		System.out.println("Data insertion success");
	}

}
