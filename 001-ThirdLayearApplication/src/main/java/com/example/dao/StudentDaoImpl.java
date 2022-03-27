package com.example.dao;

import com.example.entity.Student;
import com.example.utils.JdbcUtilsOnDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    QueryRunner queryRunner=new QueryRunner();
    Connection connection= JdbcUtilsOnDruid.getConnection();
//获取总数据量
    @Override
    public int getTotalCount() {
        String sql="select * from student";
        List<Student> list=null;

        try {
            list=queryRunner.query(connection,sql,new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (list!=null){
            return list.size();
        }
        return 0;
    }


    @Override
    public List<Student> getList(int pageNo, int pageSize) {
        String sql="select * from student limit ?,?";

        //
        int start =(pageNo-1)*pageSize;

        List<Student> list=null;
        try {
            list=queryRunner.query(connection,sql,new BeanListHandler<>(Student.class),start,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
