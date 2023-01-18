package com.sum.struts.example.dao;

import com.sum.struts.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class InMemoryEmployeeDao implements EmployeeDao {

    private static ArrayList<Employee> employees;

    static {
        employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "Quang", "Hòa", 26));
        employees.add(new Employee(2, "Quang", "Thuận", 18));
    }

    @Override
    public List getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployee(Integer id) {
        Employee emp = null;
        for (Employee employee : employees) {
            emp = employee;
            if (emp.getEmployeeId().equals(id)) {
                break;
            }
        }
        return emp;
    }

    @Override
    public void update(Employee emp) {
        Integer id = emp.getEmployeeId();
        for (int i = 0; i < employees.size(); i++) {
            Employee tempEmp = employees.get(i);
            if (tempEmp.getEmployeeId().equals(id)) {
                employees.set(i, emp);
                break;
            }
        }
    }

    @Override
    public void insert(Employee emp) {
        int lastId = 0;
        for (Employee temp : employees) {
            if (temp.getEmployeeId() > lastId) {
                lastId = temp.getEmployeeId();
            }
        }
        emp.setEmployeeId(lastId + 1);
        employees.add(emp);
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i < employees.size(); i++) {
            Employee tempEmp = employees.get(i);
            if (tempEmp.getEmployeeId().equals(id)) {
                employees.remove(i);
                break;
            }
        }
    }
}