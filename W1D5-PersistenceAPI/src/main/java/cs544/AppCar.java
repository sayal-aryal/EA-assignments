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

        // Create new instance of Car and set values in it
        Car car1 = new Car("BMW", "SDA231", 30221.00);
        // save the car
        em.persist(car1);
        // Create new instance of Car and set values in it
        Car car2 = new Car("Mercedes", "HOO100", 4088.00);
        // save the car
        em.persist(car2);

        //  Update the code in AppCar.java (right after the two cars have been persisted):
        //  Print “Em contains Car1 before clear” if it contains car1 after car2 has been persisted
        //  Clear the entity manager cache
        //  Print “Em contains Car1 after clear” if it contains car1 after the clear

        if(em.contains(car1)) System.out.println("Entity Manager contains Car1 before clear");
        em.clear();
        if(em.contains(car1)) System.out.println("Entity Manager contains Car1 after clear");

        // Change the price of car1 to 50000
        // Merge car1 (but do not store the return value of merge)
        // Change the year of car1 to 2022

        car1.setPrice(50000);
        em.merge(car1);
        car1.setYear("2022");

        //In the output, the year value has not changed in the database yet. When you call em.merge(car1),
        //the merge operation returns a new managed entity object. This returned object represents the managed
        //entity within the persistence context. If you don't assign it to car1, you won't have a reference to
        //the managed entity, and subsequent changes to car1 will not affect the managed entity.

        //To change the year as well
        Car car1afterMerge=em.merge(car1);
        car1afterMerge.setYear("2022");

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // retieve all cars
        TypedQuery<Car> query = em.createQuery("from Car", Car.class);
        List<Car> carList = query.getResultList();
        for (Car car : carList) {
            System.out.println("brand= " + car.getBrand() + ", year= "
                    + car.getYear() + ", price= " + car.getPrice());
        }
        em.getTransaction().commit();
        em.close();
    }
}

