package cs544.association2_f;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class DepartmentF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "department")
    private Set<EmployeeF> employees;

    public DepartmentF(String name) {
        this.name = name;
        this.employees = new HashSet<>();
    }

    public void addEmployee(EmployeeF employee) {
        employees.add(employee);
    }
}
