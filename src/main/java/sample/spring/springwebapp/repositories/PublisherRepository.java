package sample.spring.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sample.spring.springwebapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
