package com.usoft.service;

import com.usoft.dao.DepartmentDao;
import com.usoft.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zc
 * @create 2019-04_25-19:28
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> getAllDepartments(){
        return departmentDao.getAllDepartments();
    }

}
