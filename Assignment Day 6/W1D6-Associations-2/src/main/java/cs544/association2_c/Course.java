package cs544.association2_c;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer courseNumber;
    private String name;
    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = { @JoinColumn(name="course_id")},
            inverseJoinColumns = {@JoinColumn(name="student_id")})
    private List<Student> students;

    public Course(Integer courseNumber, String name) {
        this.courseNumber = courseNumber;
        this.name = name;
        this.students = new ArrayList<>();

    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
