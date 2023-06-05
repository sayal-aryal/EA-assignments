package cs544;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Entity
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "school_id")
    @MapKey(name="studentId")
    private Map<Long,Student> students;

    public School(String name, Student student) {
        this.name = name;
        this.students = new HashMap<>();
        this.students.put(student.getStudentid(), student);
    }

}
