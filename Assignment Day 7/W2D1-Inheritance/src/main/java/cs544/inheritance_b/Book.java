package cs544.inheritance_b;

import cs544.inheritance_a.Product;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Book extends Product {
    private String title;

    public Book(String name, String description, String title) {
        super(name, description);
        this.title = title;
    }

}
