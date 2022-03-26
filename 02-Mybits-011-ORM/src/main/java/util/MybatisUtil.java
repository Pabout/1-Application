package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    //工厂对象
    private static  SqlSessionFactory FACTORY;

    //保证线程安全
    private  static final ThreadLocal<SqlSession> SESSIONS=new ThreadLocal<>();

    static{
        //加载资源
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            FACTORY= new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取sqlsession
    private static SqlSession openSession(){
        SqlSession session = SESSIONS.get();
        if (session!=null){
            session = FACTORY.openSession();
        }

        SESSIONS.set(session);
        return  session;
    }

    //关闭连接
    private static void close(){
        SqlSession session=SESSIONS.get();;

        session.close();

        SESSIONS.remove();
    }
    //获取接口实现类
    public static <T> T getMapper(Class<T> clazz){
        SqlSession session=SESSIONS.get();

        return session.getMapper(clazz);
    }
    public static void commit(){
        SqlSession session = openSession();
        session.commit();
        close();
    }
    public static void rollback(){
        SqlSession session = openSession();
        session.rollback();
        close();
    }
}
