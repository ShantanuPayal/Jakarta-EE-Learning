package mypack;

import mypack.Weapon;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
public static void main(String[] args)
{
    BeanFactory beanfactory=new ClassPathXmlApplicationContext("injection.xml");
    System.out.println("after beanfactory creation");
    Soldier s1=(Soldier)beanfactory.getBean("s1");
    s1.perform();
   
}
}

