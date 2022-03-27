package test;


import dao.StudentDao;
import entity.Student;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class DynamicSQLTest {
    @Test
    public void testFindStudentWithTrim(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1);
        List<Student> students = studentDao.findByStudentWithTrim(student);
        for (Student student1 : students) {
            System.out.println(student1);
        }
        MybatisUtil.commit();
    }

@Test
    public void testFindAll(){
    StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
    List<Student> students = studentDao.findAll();
    for (Student student : students) {
        System.out.println(student);
    }
    MybatisUtil.commit();
}
@Test
    public void testFind(){
    StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
    List<Student> students = studentDao.findByKeyword("", 17);
    for (Student student : students) {
        System.out.println(student);
    }
    MybatisUtil.commit();
}
    @Test
    public void testFindStudent(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1);
        List<Student> students = studentDao.findByStudent(student);
        for (Student student1 : students) {
            System.out.println(student1);
        }
        MybatisUtil.commit();
    }
    @Test
    public void testUpdate(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(26);
        int affect = studentDao.update(student);
        System.out.println(affect);
        MybatisUtil.commit();
    }
    @Test
    public void testUpdateWithTrim(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(26);
        student.setName("社奉行绫华");
        int affect = studentDao.updateWithTrim(student);
        System.out.println(affect);
        MybatisUtil.commit();
    }
    @Test
    public void delete(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        int affect = studentDao.deleteMore(23,33);
        MybatisUtil.commit();
    }
}
