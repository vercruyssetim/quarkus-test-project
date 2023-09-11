package com.switchfully;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/countries")
public class CountryResource {

    private final CountryRepository countryRepository;

    public CountryResource(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDTO> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(t -> new PersonDTO(t.id(), t.firstName(), t.lastName()))
                .toList();
    }
}
