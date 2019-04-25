package com.usoft.service;

import com.usoft.dao.EmployeeDao;
import com.usoft.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zc
 * @create 2019-04_25-12:47
 */
@Service
public class EmployService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getEmployeeList(){
        return employeeDao.getEmployList();
    }

    public void employeeDelete(Integer id){
        employeeDao.employeeDelete(id);
    }

    public void employeeAdd(Employee employee){
        employeeDao.empployeeAdd(employee);
    }

    public Employee getEmployee(Integer id){
        return employeeDao.getEmployee(id);
    }

}
