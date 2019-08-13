
package com.ashsoft.dao;

import com.ashsoft.entity.Employee;

public interface EmployeeDao {
    public String insert(Employee employee);
    public Employee search(int eno);
    public String update(Employee employee);
    public String delete(Employee employee);
}
