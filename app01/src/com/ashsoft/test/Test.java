
package com.ashsoft.test;

import com.ashsoft.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class Test {

    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        cfg.configure("/com/ashsoft/resources/hibernate.cfg.xml");
        
        StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder();
	builder=builder.applySettings(cfg.getProperties());
        StandardServiceRegistry registry=builder.build();
        SessionFactory sessionFactory=cfg.buildSessionFactory(registry);    //creating sf object in 4.x version
	Session session=sessionFactory.openSession();
        
        Transaction tx= session.beginTransaction();
        Employee emp= new Employee();
        emp.setEno(111);
        emp.setEname("AAA");
        emp.setEsal(5000);
        emp.setEaddr("Delhi");
        
        session.save(emp);
        tx.commit();
        System.out.println("Employee Inserted successfully");
        
        session.close();
        sessionFactory.close();       
        
    }   
}
