package test;

import dao.StudentMapper;
import entity.Student;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class LazyTest {
@Test
    public void test(){
    StudentMapper studentMapper = MybatisUtil.getMapper(StudentMapper.class);
    List<Student> students = studentMapper.selectByExample(null);
    for (Student student : students) {
        System.out.println(student);
    }
}
}

