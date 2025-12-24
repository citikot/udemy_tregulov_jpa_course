package online.agatstudio.crud.jdbc_entry.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private Long id;
    private String name;
    private String surname;
    private Double avgGrade;

    public Student() {
    }

    public Student(String name, String surname, Double avgGrade) {
        this.name = name;
        this.surname = surname;
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
