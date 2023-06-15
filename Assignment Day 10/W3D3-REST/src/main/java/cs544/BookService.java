package cs544;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookService {
private IBookDAO bookDao;

public BookService(IBookDAO bookDao) {
this.bookDao = bookDao;
}

public List<Book> getAll() {
return bookDao.findAll();
}

public int add(Book book) {
 return bookDao.save(book).getId();
}

public Book get(int id) {
return bookDao.findById(id).get();
}

public void update(Book book) {
bookDao.save(book);
}

public void delete(int id) {
bookDao.deleteById(id);
}


}
