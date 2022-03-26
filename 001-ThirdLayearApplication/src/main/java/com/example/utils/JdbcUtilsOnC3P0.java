package com.example.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtilsOnC3P0 {
    // 声明一个c3p0连接池
    private static ComboPooledDataSource pool = new ComboPooledDataSource();
    private static Connection connection = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;

    /**
     * 获取连接
     *
     * @return 返回数据库的连接
     */
    public static Connection getConnection() {

        try {
            // 通过c3p0连接池获取连接
            connection = pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /*
     * 重载关闭资源方法，以满足多种场景
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