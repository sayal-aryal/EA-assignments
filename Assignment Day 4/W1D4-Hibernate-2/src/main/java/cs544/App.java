package cs544;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Random;

public class App {

    private static final String PERSISTENCE_UNIT_NAME = "simpsons";

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        retrieveStudentsAndDisplayNames(entityManager);
        addStudent(entityManager, "Nischal Aryal");
        retrieveStudentsAndDisplayNames(entityManager);
        entityManager.close();
        entityManagerFactory.close();
    }
    private static void retrieveStudentsAndDisplayNames(EntityManager entityManager) {
        List<Students> students = entityManager.createQuery("FROM cs544.Students", Students.class).getResultList();
        System.out.println("Students:");
        for (Students student : students) {
            System.out.println(student.getName());
        }
    }
    private static void addStudent(EntityManager entityManager, String name) {
        entityManager.getTransaction().begin();
    
        Students student = new Students();
        student.setId(generateRandomId());
        student.setName(name);
    
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    
        System.out.println("New student added: " + name);
    }
    
    private static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(1000) + 1;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}







  

   
