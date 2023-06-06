package main;

import cs544.Appointment;
import cs544.Doctor;
import cs544.Patient;
import cs544.Payment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Patient patient1 = new Patient("patient1","Iowa","52557","Fairfield");
        Patient patient2 = new Patient("patient2","Osaka","58688","Namba");

        Doctor doctor1 = new Doctor("Optometrists","John","Doe");
        Doctor doctor2 = new Doctor("Dentist","Tom","Haglon");

        Payment payment1 = new Payment("2023/07/13",500);
        Payment payment2 = new Payment("2028/04/24",300);

        Appointment appointment1 = new Appointment("2023/07/13",patient1,payment1,doctor1);
        Appointment appointment2 = new Appointment("2023/07/14",patient2,payment2,doctor1);
        Appointment appointment3 = new Appointment("2023/07/15",patient1,payment1,doctor2);

        em.persist(patient1);
        em.persist(patient2);
        em.persist(doctor1);
        em.persist(doctor2);
        em.persist(appointment1);
        em.persist(appointment2);
        em.persist(appointment3);


        em.getTransaction().commit();
        em.close();
    }
}