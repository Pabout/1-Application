package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {
    //查询小于指定年龄的学生
    List<Student> findLessThanAge(Integer age);
    //查询大于指定年龄的学生
    List<Student> findGreaterThanAge(Integer age);
}
