package sample.spring.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sample.spring.springwebapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
