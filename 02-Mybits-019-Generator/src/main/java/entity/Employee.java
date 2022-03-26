package entity;

public class Employee {
    private Integer id;

    private String name;

    private Byte salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getSalary() {
        return salary;
    }

    public void setSalary(Byte salary) {
        this.salary = salary;
    }
}