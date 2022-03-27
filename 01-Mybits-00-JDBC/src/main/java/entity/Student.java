package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.experimental.theories.DataPoint;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private  Integer id;
    private String name;
    private Byte age;
    private String gender;
    private String info;
}
