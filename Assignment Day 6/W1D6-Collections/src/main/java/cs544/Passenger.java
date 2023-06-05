package cs544;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "passenger_id")
    private List<Flight> flights ;



    public Passenger(String name, Flight flight) {
        this.name = name;
        this.flights = new ArrayList<>(Arrays.asList(flight));;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }
}
