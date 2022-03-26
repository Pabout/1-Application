package com.example.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    // ʹ�þ�̬�������г�ʼ����������������
    static {
        try {
            // ����Properties�������ڴ�Properties�ļ��ж�ȡ����
            Properties properties = new Properties();

            // ͨ���ַ��������������ݵ�properties��
            properties.load(new FileReader("./src/db.properties"));

            // ��ȡ��Ӧ������
            String driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");

            // ��������
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ����
     *
     * @return �������ݿ������
     */
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * ��ȡ���˹�����
     *
     * @return ����һ�����˹�����
     */
    private static Statement getStatement() {
        if (connection == null) {
            connection = getConnection();
        }

        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return statement;
    }

    /**
     * ��ɾ�ķ���
     *
     * @param sql ����һ��SQL���
     * @return ������Ӱ�������
     */
    public static int executeUpdate(String sql) {
        if (statement == null) {
            statement = getStatement();
        }

        int affectedRows = 0;

        try {
            affectedRows = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // �ر���Դ
            close(statement, connection);
        }

        return affectedRows;
    }

    /**
     * ��ѯ����
     *
     * @param sql ����һ��SQL���
     * @return ����һ����Ӱ�������
     */
    public static ResultSet executeQuery(String sql) {
        try {
            resultSet = getStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
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
