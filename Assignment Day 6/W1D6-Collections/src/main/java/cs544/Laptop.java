package cs544;

import jakarta.persistence.*;

@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String type;

    @ManyToOne
    private Employee employee;

    public Laptop() {
    }

    public Laptop(String brand, String type,Employee employee) {
        this.brand = brand;
        this.type = type;
        this.employee = employee;
    }
}
