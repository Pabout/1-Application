package test;

import dao.StudentDao;
import entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class CacheTest {
    @Test
    public void testTwo(){
        try {
            Reader reader = Resources.getResourceAsReader("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            //第一次查询
            System.out.println("第一次查询");
            studentDao.findById(26);
            session.commit();
            //第二次查询
            System.out.println("第2次查询");
            studentDao.findById(26);
            session.commit();
            //第三次查询
            System.out.println("第3次查询");
            studentDao.findById(26);
            session.commit();
            //第四次查询
            System.out.println("第4次查询");
            studentDao.findById(26);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCache(){
        try {
            Reader reader = Resources.getResourceAsReader("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student1 = studentDao.findById(26);
            //清理缓存
            session.clearCache();
            Student student2 = studentDao.findById(26);
            System.out.println(student1==student2);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCache2(){
        try {
            Reader reader = Resources.getResourceAsReader("Mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = factory.openSession();
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student1 = studentDao.findById(26);
            Student student = new Student();
            student .setId(26);
            student.setInfo("我爱你");
            studentDao.update(student);
            Student student2 = studentDao.findById(26);
            System.out.println(student1==student2);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
