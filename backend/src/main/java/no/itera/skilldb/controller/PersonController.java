package no.itera.skilldb.controller;

import com.google.common.collect.Lists;
import no.itera.skilldb.domain.Person;
import no.itera.skilldb.domain.Skill;
import no.itera.skilldb.repositories.PersonRepository;
import no.itera.skilldb.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by john.bye on 10/16/14.
 */
@Controller
@RequestMapping("/people")
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    SkillRepository skillRepository;

    @RequestMapping("/insert")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String insert() {
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

    @RequestMapping("")
    @ResponseBody
    @Transactional
    public Iterable<Person> list() {
        Iterable<Person> result = personRepository.findAll();
        List<Person> people = Lists.newArrayList(result);
        return people;
    }

}
