package test;

import dao.StudentDao;
import entity.Student;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class DruidTest {
@Test
    public void test(){
    StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
    List<Student> students = studentDao.findAll();
    for (Student student : students) {
        System.out.println(student);
    }
    MybatisUtil.commit();
}
}

