package dk.jarry.spring.playground.person.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dk.jarry.spring.playground.person.entity.Person;


@RestController
public class PersonRest {

    private static final Logger log = LoggerFactory.getLogger(PersonRest.class);

    @Autowired
	PersonService service;

    @GetMapping("/person/byLastName/{lastName}")
	public Person getPersonByLastName(@PathVariable("lastName") String lastName) {
		return service.findByLastName(lastName).get(0);
	}

    @Bean
	public CommandLineRunner demo() {
		return (args) -> {

			// save a few Persons
			service.save(new Person("Jack", "Bauer"));
			service.save(new Person("Chloe", "O'Brian"));
			service.save(new Person("Kim", "Bauer"));
			service.save(new Person("David", "Palmer"));
			service.save(new Person("Michelle", "Dessler"));

			// fetch all Persons
			log.info("Persons found with findAll():");
			log.info("-------------------------------");
			for (Person Person : service.findAll()) {
				log.info(Person.toString());
			}
			log.info("");

			// fetch an individual Person by ID
			Person Person = service.findById(1L);
			log.info("Person found with findById(1L):");
			log.info("--------------------------------");
			log.info(Person.toString());
			log.info("");

			// fetch Persons by last name
			log.info("Person found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			service.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			
			log.info("");
		};
	}

    
}
