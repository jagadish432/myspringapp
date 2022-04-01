package sample.spring.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sample.spring.springwebapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
