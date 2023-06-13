package cs544;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookService {
    private IBookDao bookDao;

    @Autowired
    public BookService(IBookDao bookDao) {
        this.bookDao = bookDao;
    }
    
    public List<Book> getAll() {
        return bookDao.findAll();
    }

    public void add(Book book) {
        bookDao.save(book);
    }

    public Book get(int id) {
        return bookDao.findById(id).get();
        // The reason for this is that getById() returns a proxy object
        //  that represents a reference to the entity but does not immediately
        //  load its associated data. When we access a lazily loaded property of
        //  the entity outside of an active transaction or session, it leads to a 
        // lazy loading exception because the data has not been loaded yet. So we
        //need to use bookDao.findById(id).get(). 
    }

    public void update(Book book) {
        bookDao.save(book);
    }

    public void delete(int id) {
        bookDao.deleteById(id);
    }
}
