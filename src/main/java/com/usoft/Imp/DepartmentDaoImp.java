package com.usoft.Imp;

import com.usoft.dao.DepartmentDao;
import com.usoft.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zc
 * @create 2019-04_25-19:26
 */
@Repository("departmentDao")
public class DepartmentDaoImp implements DepartmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    @Override
    public List<Department> getAllDepartments() {
        return getSession().createQuery("FROM Department").list();
    }
}
