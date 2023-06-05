package cs544;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String flightnumber;
    @Column(name = "flight_from")
    private String from;
    @Column(name = "flight_to")
    private String to;
    private LocalDate date;

    public Flight() {
    }

    public Flight(String flightnumber, String from, String to, LocalDate date) {
        this.flightnumber = flightnumber;
        this.from = from;
        this.to = to;
        this.date = date;
    }
}
