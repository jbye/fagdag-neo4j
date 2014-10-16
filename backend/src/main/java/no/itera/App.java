package no.itera;

import no.itera.skilldb.domain.Person;
import no.itera.skilldb.config.EmbeddedApplicationConfig;
import no.itera.skilldb.repositories.PersonRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                EmbeddedApplicationConfig.class);

        PersonRepository personRepository = ctx.getBean(PersonRepository.class);

        long count = personRepository.count();
        System.out.println(count);

        personRepository.save(new Person("Aleksander", "Stensby"));

        count = personRepository.count();
        System.out.println("***** " + count);

        ctx.close();
    }
}
