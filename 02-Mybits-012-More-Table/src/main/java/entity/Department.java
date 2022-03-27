package entity;

import lombok.Data;

import java.util.List;
@Data
public class Department {
    private Integer id;
    private String name;
    //一对多关系，一个部门有多个员工
    private List<Employee> employees;
}
