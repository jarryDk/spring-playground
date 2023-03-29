package dk.jarry.spring.playground.person.boundary;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dk.jarry.spring.playground.person.entity.Person;

public interface PersonService extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName);

    Person findById(long id);

}
