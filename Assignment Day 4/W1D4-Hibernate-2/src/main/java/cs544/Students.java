package cs544;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "cs544.Students")
@Table(name = "students")
public class Students {

  @Id
  @Column(name = "\"id\"", nullable = false)
  private Integer id;
  @Column(name = "\"name\"", nullable = true)
  private String name;
  @Column(name = "\"email\"", nullable = true)
  private String email;
  @Column(name = "\"password\"", nullable = true)
  private String password;
}