package cs544;

import java.util.Date;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class AppBook {
    
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");

        createBooks();

        retrieveAndOutputBooks();

        updateAndDeleteBooks();

        retrieveAndOutputBooks();

        emf.close();
    }

    private static void createBooks() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book1 = new Book("Book 1", "ISBN-1", "Author 1", 29.99, new Date());
        em.persist(book1);

        Book book2 = new Book("Book 2", "ISBN-2", "Author 2", 19.99, new Date());
        em.persist(book2);

        Book book3 = new Book("Book 3", "ISBN-3", "Author 3", 39.99, new Date());
        em.persist(book3);

        em.getTransaction().commit();
        em.close();
    }

    private static void retrieveAndOutputBooks() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();
        for (Book book : bookList) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Publish Date: " + book.getPublish_date());
            System.out.println("-----------------------");
        }

        em.getTransaction().commit();
        em.close();
    }

    private static void updateAndDeleteBooks() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Book> query = em.createQuery("from Book", Book.class);
        List<Book> bookList = query.getResultList();

        Book bookToUpdate = bookList.get(0); 
        bookToUpdate.setTitle("New Title");
        bookToUpdate.setPrice(99.99);

        Book bookToDelete = bookList.get(1); 
        em.remove(bookToDelete);

        em.getTransaction().commit();
        em.close();
    }
}
