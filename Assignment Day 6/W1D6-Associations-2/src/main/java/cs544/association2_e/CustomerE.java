package cs544.association2_e;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_e")
public class CustomerE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JoinColumn(name = "customer_e_id")
    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<ReservationE> reservations;

    public CustomerE(String name) {
        this.name = name;
        this.reservations = new HashSet<>();
    }

    public void addReservation(ReservationE reservation) {
        reservations.add(reservation);
    }
}
