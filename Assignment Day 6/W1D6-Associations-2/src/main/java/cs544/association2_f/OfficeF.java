package cs544.association2_f;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class OfficeF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer roomNumber;
    private String building;

    @OneToMany(mappedBy = "office")
    @Cascade(CascadeType.ALL)
    private Set<EmployeeF> employees;

    public OfficeF(Integer roomNumber, String building) {
        this.roomNumber = roomNumber;
        this.building = building;
        this.employees = new HashSet<>();
    }

    public void addEmployee(EmployeeF employee) {
        employees.add(employee);
    }
}
