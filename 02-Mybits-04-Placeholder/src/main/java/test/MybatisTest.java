package test;


import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void testFindById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            List<Student> students = studentDao.findById("9");
            for (Student student : students) {
                System.out.println(student);
            }
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindByAge(){
        SqlSession sqlSession=null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
             sqlSession= factory.openSession();
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            List<Student> students = studentDao.findByAge("18 or 1 = 1");
            for (Student student : students) {
                System.out.println(student);
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            if (sqlSession!=null){
            sqlSession.close();
            }
        }
    }
}
