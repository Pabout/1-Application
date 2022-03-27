package dao;

import entity.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentDao {
    Department findById(@Param("id") Integer id);
}
