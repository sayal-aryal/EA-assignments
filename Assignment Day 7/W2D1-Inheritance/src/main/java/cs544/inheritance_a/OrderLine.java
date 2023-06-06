package cs544.inheritance_a;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @ManyToOne
    private Product product;

    public OrderLine(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }
}
