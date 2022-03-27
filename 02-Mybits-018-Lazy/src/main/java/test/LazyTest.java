package test;

import dao.DepartmentDao;
import dao.EmployeeDao;
import entity.Department;
import entity.Employee;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class LazyTest {
@Test
    public void test(){
    EmployeeDao employeeDao = MybatisUtil.getMapper(EmployeeDao.class);
    List<Employee> employees = employeeDao.findById(24);
    MybatisUtil.commit();

}
@Test
    public void testDepartment(){
    DepartmentDao departmentDao = MybatisUtil.getMapper(DepartmentDao.class);
    Department department = departmentDao.findById(17);
    System.out.println(department.getName());
}
}

