package cs544;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import cs544.model.Airline;
import cs544.model.Flight;

public class App {

    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        // Question A: Flights leaving the USA with a capacity > 500
        System.out.println("Question A:");
        flightsLeavingUSAWithCapacityGreaterThan500();

        // Question B: All airlines that use A380 airplanes
        System.out.println("Question B:");
        airlinesUsingA380Airplanes();

        // Question C: All flights using 747 planes that don’t belong to 'Star Alliance'
        System.out.println("Question C:");
        flightsUsing747PlanesNotBelongingToStarAlliance();

        // Question D: All flights leaving before 12pm on 08/07/2009
        System.out.println("Question D:");
        flightsLeavingBefore12PMOn08072009();
    }

    private static void flightsLeavingUSAWithCapacityGreaterThan500() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Flight> query = em.createQuery
        (
                "SELECT f FROM Flight f WHERE f.origin.country = :countryname AND f.airplane.capacity > :capacity",
                Flight.class
        );
        query.setParameter("capacity", 500);
        query.setParameter("countryname", "USA");
        List<Flight> flightList = query.getResultList();
        flightList.forEach(flight -> System.out.println(flight.toString()));
        em.getTransaction().commit();
        em.close();
        System.out.println();
    }

    private static void airlinesUsingA380Airplanes() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Airline> query = em.createQuery
        (
                "SELECT airline FROM Flight AS f WHERE f.airplane.model = :model",
                Airline.class
        );
        query.setParameter("model", "A380");
        List<Airline> airlineList = query.getResultList();
        airlineList.forEach(airline -> System.out.println(airline.toString()));
        em.getTransaction().commit();
        em.close();
        System.out.println();
    }

    private static void flightsUsing747PlanesNotBelongingToStarAlliance() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Flight> query = em.createQuery
        (
                "FROM Flight as f WHERE f.airplane.model= :model AND f.airline.name = :airlineName",
                Flight.class
        );
        query.setParameter("model", "A380");
        query.setParameter("airlineName", "Star Alliance");
        List<Flight> flightList = query.getResultList();
        flightList.forEach(flight -> System.out.println(flight.toString()));
        em.getTransaction().commit();
        em.close();
        System.out.println();
    }
   
    private static void flightsLeavingBefore12PMOn08072009() throws ParseException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
       DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US);
       
       System.out.println("Question D:");
       TypedQuery<Flight> query = em.createQuery
        (
               "SELECT f FROM Flight f WHERE f.departureDate = :date AND f.departureTime < :time",
               Flight.class
        );
       query.setParameter("date", df.parse("08/07/2009"));
       query.setParameter("time", tf.parse("12:00 PM"));
       List<Flight> flightsList = query.getResultList();
       System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
       for (Flight flight : flightsList) {
           System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                   flight.getFlightnr(), flight.getOrigin().getCity(),
                   flight.getDepartureDate(), flight.getDepartureTime(),
                   flight.getDestination().getCity(),
                   flight.getArrivalDate(), flight.getArrivalTime());
       }
        System.out.println();
        em.close();
        System.out.println();
    }
}

