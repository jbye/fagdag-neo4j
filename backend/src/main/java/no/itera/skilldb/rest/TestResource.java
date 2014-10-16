package no.itera.skilldb.rest;

import com.google.gson.Gson;
import no.itera.skilldb.domain.Person;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by john.bye on 10/16/14.
 */
@Path("test")
public class TestResource {

    @GET
    @Path("hello")
    @Produces("application/json")
    public String hello() {
        Gson gson = new Gson();
        return gson.toJson(new Person("Test", "Testesen"));
    }

}
