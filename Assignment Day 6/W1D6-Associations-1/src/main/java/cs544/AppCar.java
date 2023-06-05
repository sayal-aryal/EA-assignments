package cs544;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AppCar {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Owner owner1 = new Owner("Jack", "100 N 4th Street Fairfield Iowa");

        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00, owner1);
        // save the car
        em.persist(car1);
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00, owner1);
        // save the car
        em.persist(car2);

        Owner owner2 = new Owner("Shyam", "100 N 4th Street California");
        Car car3 = new Car("Honda", "HON200", 8769.00, owner2);
        // save the car
        em.persist(car3);

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice() +
                    ", Owner name= " + car.getOwner().getName() + ", Owner Address= " + car.getOwner().getAddress());
        }
        em.getTransaction().commit();
        em.close();
    }
}

