package no.itera.skilldb.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by john.bye on 10/16/14.
 */
@NodeEntity
public class Person {

    @GraphId
    @JsonIgnore
    public Long nodeId;

    @Indexed(unique = true)
    public int id;

    public String firstName;

    public String lastName;

    @RelatedToVia(type = "KNOWS")
    Set<Knows> skills = new HashSet<Knows>();

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addSkill(Skill skill) {
        this.skills.add(new Knows(this, skill));
    }

    public Long getNodeId() {
        return nodeId;
    }


    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Knows> getSkills() {
        return skills;
    }

    public void setSkills(Set<Knows> skills) {
        this.skills = skills;
    }
}