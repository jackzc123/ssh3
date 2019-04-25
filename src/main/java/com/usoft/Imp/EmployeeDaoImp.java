package com.usoft.Imp;

import com.usoft.dao.EmployeeDao;
import com.usoft.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zc
 * @create 2019-04_25-12:21
 */
@Repository("employeeDao")
public class EmployeeDaoImp implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Employee> getEmployList() {
        String sql = "from Employee";
        Query query = getSession().createQuery(sql);
        return query.list();
    }

    @Override
    public void employeeDelete(Integer id) {
        String sql = "delete from Employee where id=:id";
        Query query = getSession().createQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void empployeeAdd(Employee employee) {
        getSession().saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        return getSession().get(Employee.class, id);
    }
}
