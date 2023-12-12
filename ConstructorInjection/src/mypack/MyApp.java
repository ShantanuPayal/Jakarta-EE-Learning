package mypack;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MyApp {
    public static void main(String[] args) {
    	
        BeanFactory beanfactory=new ClassPathXmlApplicationContext("injection.xml");
     
        Soldier soldier = (Soldier)beanfactory.getBean("soldier");
        soldier.perform(); // This will perform the attack using the injected Gun object.
    }
}
