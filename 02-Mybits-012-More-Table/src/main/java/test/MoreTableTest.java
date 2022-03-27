package test;


import dao.DepartmentDao;
import dao.EmployeeDao;
import dao.StudentDao;
import dao.SubjectDao;
import entity.Department;
import entity.Employee;
import entity.Student;
import entity.Subject;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class MoreTableTest {
    @Test
    public void testSub(){
        SubjectDao subjectDao = MybatisUtil.getMapper(SubjectDao.class);
        List<Subject> subjects = subjectDao.findAll();
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
    }

    @Test
    public void testStu(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        MybatisUtil.commit();
    }

    @Test
    public void testDepartment(){
        DepartmentDao departmentDao = MybatisUtil.getMapper(DepartmentDao.class);

        List<Department> departments = departmentDao.findAll();

        for (Department department : departments) {
            System.out.println(department);
        }
        MybatisUtil.commit();
    }

    @Test
    public void testEmployee(){
        EmployeeDao employeeDao = MybatisUtil.getMapper(EmployeeDao.class);

        List<Employee> employees = employeeDao.findAll();

        for (Employee employee : employees) {
            System.out.println(employee);
        }
        MybatisUtil.commit();
    }
@Test
    public void test(){
    EmployeeDao employeeDao = MybatisUtil.getMapper(EmployeeDao.class);
    List<Employee> employees = employeeDao.findAll();
    for (Employee employee : employees) {
        System.out.println(employee);
    }
    MybatisUtil.commit();
}
}
