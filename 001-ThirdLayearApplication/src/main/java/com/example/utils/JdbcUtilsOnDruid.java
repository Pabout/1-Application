package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtilsOnDruid {

    // ���ݿ�Դ
    private static DataSource dataSource;
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    static {
        try {
            // ����Properties�ļ�
            Properties properties = new Properties();
            properties.load(new FileReader("E:\\ecli1\\rx04_0422_zsj\\src\\druid.properties"));

            // �Ѿ�������ݿ����ӳز���
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * �������ݿ����Ӷ�������ʧ�ܷ���null
     *
     * @return java.sql.Connection ���ݿ����Ӷ���
     */
    public static Connection getConnection() {
        try {
            // ͨ������Դ��ȡ����
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /*
     * ���عر���Դ��������������ֳ���
     */
    public static void close(Connection connection) {
        close(resultSet, statement, connection);
    }

    public static void close(ResultSet resultSet) {
        close(resultSet, statement, connection);
    }

    public static void close(Statement statement, Connection connection) {
        close(resultSet, statement, connection);
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}