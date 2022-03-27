package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
public class Student {
    private Integer id;
    private String name;
    private Byte age;
    private String gender;
    private String info;
    private List<Subject> subjects;
}
