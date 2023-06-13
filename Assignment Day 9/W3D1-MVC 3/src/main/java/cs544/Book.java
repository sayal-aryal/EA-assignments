package cs544;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class Book {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String ISBN;
    private String author;
    private double price;

    public Book() {
    }

    public Book(Integer id, String title, String ISBN, String author, double price) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
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

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
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

    public Book id(Integer id) {
        setId(id);
        return this;
    }

    public Book title(String title) {
        setTitle(title);
        return this;
    }

    public Book ISBN(String ISBN) {
        setISBN(ISBN);
        return this;
    }

    public Book author(String author) {
        setAuthor(author);
        return this;
    }

    public Book price(double price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(ISBN, book.ISBN) && Objects.equals(author, book.author) && price == book.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ISBN, author, price);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", ISBN='" + getISBN() + "'" +
            ", author='" + getAuthor() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
    
}
