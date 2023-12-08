package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
		
		Student s1=new Student();
		s1.setName("Shantanu");
		s1.setAge(22);
		s1.setAddress("juhu");
		
		
		Student s2=new Student();
		s2.setName("Harleen");
		s2.setAge(22);
		s2.setAddress("Bhuswal");
		
		session.persist(s1);
		session.persist(s2);
		
		tr.commit();
		
		 factory.close();
		 System.out.println("done with students");  
		
		
	}
}
