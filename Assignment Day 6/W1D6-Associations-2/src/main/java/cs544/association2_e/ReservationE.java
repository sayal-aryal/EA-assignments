package cs544.association2_e;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name = "reservation_e")
public class ReservationE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "book_e_id")
    private BookE book;

    public ReservationE(LocalDate date, BookE book) {
        this.date = date;
        this.book = book;
    }


}
