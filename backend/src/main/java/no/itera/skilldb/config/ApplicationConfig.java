package no.itera.skilldb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

@Configuration
@ComponentScan
@EnableNeo4jRepositories("no.itera.skilldb.repositories")
public class ApplicationConfig extends Neo4jConfiguration {


    public ApplicationConfig(){
        setBasePackage("no.itera.skilldb.domain");
    }

}