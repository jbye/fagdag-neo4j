package no.itera.skilldb.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.data.neo4j.annotation.*;

/**
 * Created by john.bye on 10/16/14.
 */
@RelationshipEntity(type = "KNOWS")
public class Knows {

    @GraphId
    @JsonIgnore
    public Long nodeId;

    @JsonIgnore
    @StartNode
    Person person;

    @EndNode
    Skill skill;

    public Knows() {

    }

    public Knows(Person p, Skill s) {
        this.person = p;
        this.skill = s;
    }

    public Person getPerson() {
        return person;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
