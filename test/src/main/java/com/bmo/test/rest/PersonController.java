package com.bmo.test.rest;

import com.bmo.test.model.Person;
import com.bmo.test.repo.PersonRepo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Component
@Path("/person")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "Person Controller", produces = "application/json")
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<List<Person>> getPersonsData(){
        return new ResponseEntity<List<Person>>(personRepo.findAll(), HttpStatus.OK);
    }

    @POST
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertPersonsData(
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName
    ){
        personRepo.insertUser(firstName,lastName);
        return Response
                .status(Response.Status.OK)
                .build();
    }

}