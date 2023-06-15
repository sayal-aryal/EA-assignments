package cs544;

import org.springframework.data.jpa.repository.JpaRepository;

interface IBookDAO extends JpaRepository<Book,Integer> {
    
}
