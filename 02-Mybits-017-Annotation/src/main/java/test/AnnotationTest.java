package test;

import dao.StudentDao;
import entity.Student;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class AnnotationTest {
@Test
    public void test(){
    StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
    List<Student> students = studentDao.findAll();
    for (Student student : students) {
        System.out.println(student);
    }
    MybatisUtil.commit();
}
    @Test
    public void testFindById(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        Student student = studentDao.findById(26);
            System.out.println(student);
        MybatisUtil.commit();
    }
    @Test
    public void testInsert(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("上杉绘梨衣");
        student.setAge((byte)21);
        student.setGender("女");
        student.setInfo("路明非");
        studentDao.insert(student);
        MybatisUtil.commit();
    }
    @Test
    public void testUpdate(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(26);
        student.setInfo("优雅永不过时");
        studentDao.update(student);
        MybatisUtil.commit();
    }
    @Test
    public void testDelete(){
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        studentDao.delete(24);
        MybatisUtil.commit();
    }
}

