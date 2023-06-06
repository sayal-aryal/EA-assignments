package cs544.inheritance_a;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "order_a")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;
    private LocalDate date;
    @ManyToOne
    private Customer customer;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLines;

    public Order(LocalDate date, Customer customer) {
        this.date = date;
        this.customer = customer;
        orderLines = new ArrayList<>();
    }
    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
    }

}
