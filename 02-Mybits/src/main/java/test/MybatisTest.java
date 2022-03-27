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
    public  void testFindStudentById(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            Student student = studentDao.findStudentById(9);
            System.out.println(student);
            sqlSession.commit();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindAll(){
        //读取配置文件，获取流
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            List<Student> students = studentDao.findAll();

            for (Student student : students) {
                System.out.println(student);
            }
            //提交事务
            sqlSession.commit();
            //关闭资源
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testInterface(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            //通过反射获取接口的实现类
            StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
            Student student = studentDao.findById();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void teatInsert(){
        try {
            //读取配置文件中的内容到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //构建sqlsession工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //生产sqlsession
            SqlSession sqlSession = factory.openSession();
            //
            int affected = sqlSession.insert("StudentMapper.insert");
            System.out.println("受影响的行数"+affected);
            //提交事务
            sqlSession.commit();
            //关闭资源
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test(){
        try {
            //读取配置文件中的内容到流中
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获取mybatis核心类对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //通过会话工厂获取链接,相当于queryqunner
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //sqlSession
            Object o = sqlSession.selectOne("StudentMapper.select");
            System.out.println(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
          }
}
