package no.itera.skilldb.config;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by john.bye on 10/16/14.
 */
@Configuration
public class EmbeddedApplicationConfig extends ApplicationConfig {

    @Bean
    GraphDatabaseService graphDatabaseService() {

        return new GraphDatabaseFactory().newEmbeddedDatabase("tmp/neo4j");

    }

}