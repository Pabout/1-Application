package test;

import com.example.vo.PageInfo;
import dao.StudentDao;
import entity.Student;
import org.junit.Test;
import util.MybatisUtil;

import java.util.List;


public class PageHelperTest {
@Test
    public void test( ){
    StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);

    List<Student> students = studentDao.findAll();
//    PageInfo pageInfo = new PageInfo<>(students);
    //System.out.println(pageInfo);
    }
}

