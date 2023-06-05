package cs544.main;

import cs544.association2_a.Department;
import cs544.association2_a.Employee;
import cs544.association2_b.Book;
import cs544.association2_b.Publisher;
import cs544.association2_c.Course;
import cs544.association2_c.Student;
import cs544.association2_d.Reservation;
import cs544.association2_e.BookE;
import cs544.association2_f.DepartmentF;
import cs544.association2_f.EmployeeF;
import cs544.association2_f.OfficeF;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
//Question A

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Department department = new Department("TI");
        Employee employee = new Employee("John", 123, department);
        em.persist(employee);
        em.getTransaction().commit();
        em.close();

        //Question B

        em = emf.createEntityManager();
        em.getTransaction().begin();


        Book book1 = new Book(123, "JAva", "Author1");
        Publisher publisher1 = new Publisher("publisher 1");
        book1.setPublisher(publisher1);
        em.persist(publisher1);
        em.persist(book1);

        Book book2 = new Book(678, "Spring", "Author2");
        em.persist(book2);

        em.getTransaction().commit();
        em.close();

        //Question C
//
        em = emf.createEntityManager();
        em.getTransaction().begin();

        Course course = new Course(123, "Course 1");
        Student student = new Student(456, "John", "Doe");
        student.addCourse(course);
        course.addStudent(student);
        em.persist(course);

        em.getTransaction().commit();
        em.close();
//
//        //Question D
        em = emf.createEntityManager();
        em.getTransaction().begin();
        cs544.association2_d.Customer customer = new cs544.association2_d.Customer("Customer1");
        Reservation reservation = new Reservation(LocalDate.of(1997, 7, 13));
        customer.addReservation(reservation);
        em.persist(customer);
        em.getTransaction().commit();
        em.close();
//
//        //Question E
//
        em = emf.createEntityManager();
        em.getTransaction().begin();

        cs544.association2_e.CustomerE customer_e = new cs544.association2_e.CustomerE("Test CustomerE");
        BookE book_e = new BookE(123, "Test Title", "Test Author");
        cs544.association2_e.ReservationE reservation_e = new cs544.association2_e.ReservationE(LocalDate.of(1995, 3, 3), book_e);
        em.persist(book_e);
        customer_e.addReservation(reservation_e);
        em.persist(customer_e);

        em.getTransaction().commit();
        em.close();

        //Question F
//
        em = emf.createEntityManager();
        em.getTransaction().begin();


        DepartmentF department_f = new DepartmentF("Test dep F");
        OfficeF office = new OfficeF(123, "TEst building");
        EmployeeF employee_f = new EmployeeF("Test Employee", 123, department_f, office);
        department_f.addEmployee(employee_f);
        em.merge(office);
        em.merge(department_f);


        em.getTransaction().commit();
        em.close();

    }
}