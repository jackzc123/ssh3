package com.usoft.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.usoft.entity.Employee;
import com.usoft.service.DepartmentService;
import com.usoft.service.EmployService;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author zc
 * @create 2019-04_25-12:48
 */
@Controller
@Scope("prototype")
public class EmployeeAction extends ActionSupport implements RequestAware,ModelDriven<Employee>,Preparable {

    @Autowired
    private EmployService employService;

    @Autowired
    private DepartmentService departmentService;

    public String employList(){
        List<Employee> employeeList = employService.getEmployeeList();
        requestMap.put("employList", employeeList);
        return "success";
    }

    public String employDelete(){
        employService.employeeDelete(id);
        return "success";
    }

    public String employAdd(){
        if(id == null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd  hh:mm:ss");
            java.util.Date date = new java.util.Date();
            System.out.println(simpleDateFormat.format(date));
            java.sql.Date dateSql = new java.sql.Date(date.getTime());
            employee.setCreateTime(dateSql);
        }
        employService.employeeAdd(employee);
        return "success";
    }

    public void prepareEmployAdd(){
        if(id == null){
            employee = new Employee();
        } else {
            employee = employService.getEmployee(id);
        }
    }

    public String toAdd(){
        requestMap.put("departments",departmentService.getAllDepartments());
        return "success";
    }

  /*  public void prepareToAdd(){

    }*/

    public String toUpdate(){
        requestMap.put("departments",departmentService.getAllDepartments());
        return "success";
    }

    public void prepareToUpdate(){
        employee = employService.getEmployee(id);
    }


    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Employee employee;

    @Override
    public Employee getModel() {
        return employee;
    }

    @Override
    public void prepare() throws Exception {
    }

    private Map<String, Object> requestMap;

    @Override
    public void setRequest(Map<String, Object> map) {
        this.requestMap = map;
    }
}
