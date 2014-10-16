package no.itera.skilldb.repositories;

import no.itera.skilldb.domain.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by john.bye on 10/16/14.
 */
public interface PersonRepository extends GraphRepository<Person> {
    Person findByFirstName(String firstName);
}