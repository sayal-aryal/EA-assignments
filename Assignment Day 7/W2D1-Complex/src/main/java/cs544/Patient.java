package cs544;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@SecondaryTables(
        @SecondaryTable(name="Address", pkJoinColumns= {
                @PrimaryKeyJoinColumn(name="patient_id", referencedColumnName="id")
        })
)

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(table="Address")
    private String street;
    @Column(table="Address")
    private String zip;
    @Column(table="Address")
    private String city;

    public Patient(String name, String street, String zip, String city) {
        this.name = name;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }
}
