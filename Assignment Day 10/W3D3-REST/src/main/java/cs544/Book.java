package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.Objects;

import org.aspectj.apache.bcel.generic.InstructionByte;

@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
@NotBlank
private String title;


private String isbn;
@NotBlank
private String author;
@Positive
private double price;

public Book() {
}

public Book(Integer id, String title, String isbn, String author, double price) {
this.id = id;
this.title = title;
this.isbn = isbn;
this.author = author;
this.price = price;
}

public Integer getId() {
return this.id;
}

public void setId(Integer id) {
this.id = id;
}

public String getTitle() {
return this.title;
}

public void setTitle(String title) {
this.title = title;
}

public String getisbn() {
return this.isbn;
}

public void setisbn(String isbn) {
this.isbn = isbn;
}

public String getAuthor() {
return this.author;
}

public void setAuthor(String author) {
this.author = author;
}

public double getPrice() {
return this.price;
}

public void setPrice(double price) {
this.price = price;
}


@Override
public boolean equals(Object o) {
if (o == this)
return true;
if (!(o instanceof Book)) {
return false;
}
Book book = (Book) o;
return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn) && Objects.equals(author, book.author) && price == book.price;
}

@Override
public int hashCode() {
return Objects.hash(id, title, isbn, author, price);
}

@Override
public String toString() {
return "{" +
" id='" + getId() + "'" +
", title='" + getTitle() + "'" +
", isbn='" + getisbn() + "'" +
", author='" + getAuthor() + "'" +
", price='" + getPrice() + "'" +
"}";
}

}