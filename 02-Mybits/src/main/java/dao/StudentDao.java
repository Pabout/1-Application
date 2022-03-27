package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {
    Student findById();

    List<Student> findAll();

    Student findStudentById(Integer id);
}
