package dao;

import com.example.vo.PageInfo;
import entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();

}
