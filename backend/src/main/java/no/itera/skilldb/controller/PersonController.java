package no.itera.skilldb.controller;

import com.google.common.collect.Lists;
import no.itera.skilldb.domain.Person;
import no.itera.skilldb.domain.Skill;
import no.itera.skilldb.repositories.PersonRepository;
import no.itera.skilldb.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by john.bye on 10/16/14.
 */
@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    SkillRepository skillRepository;

    @RequestMapping("/insert")
    public
    @ResponseBody
    String insert() {
        Gson gson = new Gson();

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

    @RequestMapping("/people")
    public
    @ResponseBody
    Person list() {
        Gson gson = new Gson();
        Person person = personRepository.findByFirstName("John");
        return person;
    }

}
