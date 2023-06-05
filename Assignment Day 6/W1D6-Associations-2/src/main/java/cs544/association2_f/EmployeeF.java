package cs544.association2_f;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EmployeeF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer employeeNumber;
    @ManyToOne
    private DepartmentF department;
    @ManyToOne
    private OfficeF office;

    public EmployeeF(String name, Integer employeeNumber, DepartmentF department, OfficeF office) {
        this.name = name;
        this.employeeNumber = employeeNumber;
        this.department = department;
        this.office = office;
    }

}
