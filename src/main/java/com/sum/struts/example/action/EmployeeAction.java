package com.sum.struts.example.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.sum.struts.example.model.Employee;
import com.sum.struts.example.service.DefaultEmployeeService;
import com.sum.struts.example.service.EmployeeService;

import java.util.List;

public class EmployeeAction extends ActionSupport implements Preparable {
    private EmployeeService empService = new DefaultEmployeeService();

    private Employee employee;
    private List employees;

    @Override
    public void prepare() throws Exception {
        if (employee != null && employee.getEmployeeId() != null) {
            employee = empService.getEmployee(employee.getEmployeeId());
        }
    }

    public String save() {
        if (employee.getEmployeeId() == null) {
            empService.insertEmployee(employee);
        } else {
            empService.updateEmployee(employee);
        }
        return SUCCESS;
    }

    public String delete() {
        empService.deleteEmployee(employee.getEmployeeId());
        return SUCCESS;
    }

    public String list() {
        employees = empService.getAllEmployees();
        return SUCCESS;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List getEmployees() {
        return employees;
    }
}
