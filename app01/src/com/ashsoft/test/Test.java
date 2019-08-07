
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
        
        /*Transaction tx= session.beginTransaction();
        Employee emp= new Employee();
        emp.setEno(111);
        emp.setEname("CCC");
        emp.setEsal(6000);
        emp.setEaddr("Pune");*/
        
        //session.saveOrUpdate(emp);
        //session.save(emp);
        
        //session.delete(emp);
        //tx.commit();
        //System.out.println("Employee Inserted/Updated/deleted successfully");
        
        Employee emp=(Employee) session.get("com.ashsoft.entity.Employee",111);
        
        System.out.println("Employee Details");
        System.out.println("----------------------------");
        System.out.println("Employee No      : "+emp.getEno());
        System.out.println("Employee Name    : "+emp.getEname());
        System.out.println("Employee Salary  : "+emp.getEsal());
        System.out.println("Employee Address : "+emp.getEaddr());
                
        session.close();
        sessionFactory.close();       
        
    }   
}
