package no.itera.skilldb.rest;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import no.itera.skilldb.config.EmbeddedApplicationConfig;
import no.itera.skilldb.domain.Person;
import no.itera.skilldb.domain.Skill;
import no.itera.skilldb.repositories.PersonRepository;
import no.itera.skilldb.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.neo4j.conversion.Result;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john.bye on 10/16/14.
 */
@Path("people")
public class PersonResource {

    /*
    private PersonRepository personRepository;

    public PersonResource() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                EmbeddedApplicationConfig.class);

        this.personRepository = ctx.getBean(PersonRepository.class);
    }*/

    @GET
    @Path("insert")
    @Produces("text/plain")
    public String insert() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                EmbeddedApplicationConfig.class);

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);
        SkillRepository skillRepository = ctx.getBean(SkillRepository.class);

        skillRepository.deleteAll();
        personRepository.deleteAll();

        Skill s = new Skill("java");
        Skill s2 = new Skill("neo4j");
        skillRepository.save(s);
        skillRepository.save(s2);

        Person p = new Person("John", "Bye");
        p.addSkill(s);
        p.addSkill(s2);

        personRepository.save(p);

        return "OK";
    }

    @GET
    @Path("by_skill")
    @Produces("application/json")
    public String getBySkill() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                EmbeddedApplicationConfig.class);
        PersonRepository personRepository = ctx.getBean(PersonRepository.class);

        Result<Person> people = personRepository.findAll();
        //List<Person> peopleWithSkill = personRepository.findByKnowsSkillName("java");
        //List<Person> peopleWithSkill = new ArrayList<Person>();

        Gson gson = new Gson();
        return gson.toJson(Lists.newArrayList(people.iterator()));
    }

    /*
    @GET
    @Path("skill")
    @Produces("application/json")
    public String getBySkill(@QueryParam("skills") String skills) {
        personRepository.save(new Person("Aleksander", "Stensby"));

        Gson gson = new Gson();
        return gson.toJson(new Person(skills, "" + personRepository.count()));
    }*/

}
