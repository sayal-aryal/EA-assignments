package cs544.main;

import cs544.inheritance_a.Customer;
import cs544.inheritance_a.Order;
import cs544.inheritance_a.OrderLine;
import cs544.inheritance_a.Product;
import cs544.inheritance_b.Book;
import cs544.inheritance_b.CD;
import cs544.inheritance_b.DVD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");


        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Customer customer1 = new Customer("Sayal", "Aryal");
        Product product1 = new Product("Chips", "Description For Chips");
        Order order1 = new Order(LocalDate.of(2023, 5, 20), customer1);
        OrderLine orderLine1 = new OrderLine(5, product1);


//        order1.addOrderLine(orderLine1);
//        customer1.addOrders(order1);

//        em.persist(customer1);
//        em.persist(product1);

        em.getTransaction().commit();
        em.close();

        //Question B

        em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book = new Book("Book name", "Book Desc", "Book title");
        CD cd = new CD("CD name", "CD Desc", "Cd artist");
        DVD dvd = new DVD("DVD NAme", "Dvd desc", "dvd genre");

        em.persist(book);
        em.persist(cd);
        em.persist(dvd);

        em.getTransaction().commit();
        em.close();
        printProduct();
    }

    public static void printProduct() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> list = em.createQuery("from Product", Product.class).getResultList();
        list.forEach(product -> System.out.println(product));
        em.getTransaction().commit();
        em.close();
    }
}