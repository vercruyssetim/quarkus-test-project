package com.switchfully;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/persons")
public class PersonResource {

    private final PersonRepository personRepository;

    public PersonResource(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDTO> getAllCountries() {
        return personRepository.findAll().stream()
                .map(t -> new PersonDTO(t.id(), t.firstName(), t.lastName() + "hallo"))
                .toList();
    }
}
