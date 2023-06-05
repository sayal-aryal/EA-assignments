package cs544;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        //Question A

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee employee1 = new Employee("Sayal", "Aryal", "Lenovo", "ThinkPad");
        employee1.addLapTop(new Laptop("Hp", "Type 2", employee1));
        em.persist(employee1);
        em.getTransaction().commit();
        em.close();

        //Question B

        em = emf.createEntityManager();
        em.getTransaction().begin();

        Flight flight = new Flight("MP360", "Thiland Bangkok", "New York", LocalDate.of(2023, 12, 2));
        Passenger passenger = new Passenger("sayal", flight);
        passenger.addFlight(new Flight("CZ123", "Kathmandu Nepal", "Wasington DC", LocalDate.of(2023, 9, 9)));


        em.persist(passenger);

        em.getTransaction().commit();
        em.close();


        //Question C
        em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student("Sayal", "Aryal");
        School school = new School("MY School", student);
        em.persist(school);

        em.getTransaction().commit();
        em.close();

    }
}