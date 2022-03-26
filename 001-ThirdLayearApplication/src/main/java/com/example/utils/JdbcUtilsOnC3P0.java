package com.example.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilsOnC3P0 {
    // ����һ��c3p0���ӳ�
    private static ComboPooledDataSource pool = new ComboPooledDataSource();
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    /**
     * ��ȡ����
     *
     * @return �������ݿ������
     */
    public static Connection getConnection() {

        try {
            // ͨ��c3p0���ӳػ�ȡ����
            connection = pool.getConnection();
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