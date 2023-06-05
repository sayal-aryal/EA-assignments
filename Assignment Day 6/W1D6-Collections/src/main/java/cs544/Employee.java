package cs544;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.PERSIST)
    private Set<Laptop> laptops;

    public Employee() {
    }

    public Employee(String firstname, String lastname,String laptopBrand,String laptopType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.laptops= new HashSet<>(Arrays.asList(new Laptop(laptopBrand, laptopType, this)));;
    }

    public void  addLapTop(Laptop laptop){
        laptops.add(laptop);
    }
}
