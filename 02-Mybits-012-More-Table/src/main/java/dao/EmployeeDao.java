package dao;

import entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
}
