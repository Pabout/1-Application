package test;

import dao.StudentDao;
import entity.Student;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;

public class MybatisTest {
    @Test
    public void testFindAll() {
        try {
            StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
            List<Student> students = studentDao.findAll();
            for (Student student : students) {
                System.out.println(student);
            }
            //成功就提交
            MybatisUtil.commit();
        } catch (Exception e) {

            //失败会回滚
            MybatisUtil.rollback();
            e.printStackTrace();
        }
    }
}
