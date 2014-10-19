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
public class Skill {

    @GraphId
    @JsonIgnore
    public Long nodeId;

    @Indexed(unique = true)
    public int id;

    @RelatedToVia(type = "KNOWS")
    Set<Knows> people = new HashSet<Knows>();

    public String name;

    public Skill() { }

    public Skill(String name) {
        this.name = name;
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

    public Set<Knows> getPeople() {
        return people;
    }

    public void setPeople(Set<Knows> people) {
        this.people = people;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
