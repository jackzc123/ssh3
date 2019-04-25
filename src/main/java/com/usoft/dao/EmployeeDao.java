package com.usoft.dao;

import com.usoft.entity.Employee;

import java.util.List;

/**
 * @author zc
 * @create 2019-04_25-12:19
 */
public interface EmployeeDao {
    List<Employee> getEmployList();
    void employeeDelete(Integer id);
    void empployeeAdd(Employee employee);
    Employee getEmployee(Integer id);
}
