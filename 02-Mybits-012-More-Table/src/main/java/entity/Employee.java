package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Employee {
    private  Integer id;
    private  String name;
    //一对一，一个员工一个部门
    private  Department department;

}
