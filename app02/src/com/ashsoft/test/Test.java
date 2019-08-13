
package com.ashsoft.test;

import com.ashsoft.dao.EmployeeDao;
import com.ashsoft.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("/com/ashsoft/resources/spring-config.xml");
        EmployeeDao employeeDao= (EmployeeDao) context.getBean("employeeDao");
        
        //Inserting record
        /*Employee emp= new Employee();
        emp.setEno(444);
        emp.setEname("James");
        emp.setEsal(8000);
        emp.setEaddr("London");
       
        String status=employeeDao.insert(emp);
        System.out.println(status);*/
        
        //Searching record
        /*Employee emp=employeeDao.search(222);
        if(emp==null)
        {
            System.out.println("Employee not Existed in database");
        }
        else
        {
            System.out.println("Emplyoyee Details");
            System.out.println("------------------------------");
            System.out.println("Employee No       :"+emp.getEno());
            System.out.println("Employee Name     :"+emp.getEname());
            System.out.println("Employee Salary   :"+emp.getEsal());
            System.out.println("Employee Address  :"+emp.getEaddr());
        }   */
        
        //Updating record
        /*Employee emp= new Employee();
        emp.setEno(222);
        emp.setEname("Raghu");
        emp.setEsal(10000);
        emp.setEaddr("Uganda");
        
        String status=employeeDao.update(emp);
        System.out.println(status);*/
        
        //deleting record
        Employee emp= new Employee();
        emp.setEno(222);
        String status=employeeDao.delete(emp);
        System.out.println(status);
    }  
}
