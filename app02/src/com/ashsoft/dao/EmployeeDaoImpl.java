
package com.ashsoft.dao;

import com.ashsoft.entity.Employee;
import org.springframework.orm.hibernate4.HibernateTemplate;

import org.springframework.transaction.annotation.Transactional;

public class EmployeeDaoImpl  implements EmployeeDao{
    
    private HibernateTemplate hibernateTemplate;
     
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    @Transactional  //Provides transaction object for commit,rollback operations
    @Override
    public String insert(Employee employee) {
        String status="";
        try {
            int pk_Key=(Integer) hibernateTemplate.save(employee);
            if(pk_Key==employee.getEno())
            {
                status="Employee Inserted Successfully";
            }
            else
            {
                status="Employee Insertion Failure";
            }
        } catch (Exception e) {
            status="Employee Insertion Failure";
            e.printStackTrace();
        }
        return status;
    }

    @Override
    @Transactional
    public Employee search(int eno) {
        Employee emp=null;
        try {
            emp=hibernateTemplate.get(com.ashsoft.entity.Employee.class, eno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    @Transactional
    public String update(Employee employee) {
        String status="";
        try {
            hibernateTemplate.update(employee);
            status="Employee Updated Successfully";
        } catch (Exception e) {
            status="Employee Updation Failure";
            e.printStackTrace();
        }
        return status;
    }

    @Override
    @Transactional
    public String delete(Employee employee) {
        String status="";
        try {
            hibernateTemplate.delete(employee);
            status="Employee Deletion Success";
        } catch (Exception e) {
            status="Employee Deletion Failure";
            e.printStackTrace();
        }
        return status;
    }    
}
