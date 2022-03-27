package dao;

import entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findById(@Param("id") Integer id);
}
