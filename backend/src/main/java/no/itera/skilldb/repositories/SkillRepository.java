package no.itera.skilldb.repositories;

import no.itera.skilldb.domain.Person;
import no.itera.skilldb.domain.Skill;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by john.bye on 10/16/14.
 */
public interface SkillRepository extends GraphRepository<Skill> {

}