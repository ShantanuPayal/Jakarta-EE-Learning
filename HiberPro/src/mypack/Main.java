package mypack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Main 
{
	public static void main(String[] args) 
	{
		Configuration cfg=new Configuration();
		//comfiguration is class derived from org.hibernate.configuration
		cfg.configure("hibernate.cfg.xml");
		//creatin congugruation object and calling method on it
		SessionFactory factory=cfg.buildSessionFactory();//factory created with help of cfg
		Session session=factory.openSession();
		Transaction tr=session.beginTransaction();
		
		//HibernatesEsion allows to create read obejtc etc etc
		//Transcation is imp to commit the rows
        Employee e1=new Employee();
        e1.setName("abc");
        e1.setDesig("officer");
        e1.setSalary(30000);
            //we dint icall id as its auto genrated
        Employee e2=new Employee();       
        e2.setName("xyz");
        e2.setDesig("manager");
        e2.setSalary(40000);
        session.persist(e1);
        
        //till hibenrate 5 we had save but the method is depricated so use persit methid
        session.persist(e2);
        tr.commit(); 
        //tabe will be created fro frst time
        factory.close();
        System.out.println("done with employees");  
	}
}
///
//only one session factory in project but u may get multiple sessiosn from it

