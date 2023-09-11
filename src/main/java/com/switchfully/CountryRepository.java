package com.switchfully;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CountryRepository extends AbstractRepository {

    public List<Person> findAll() {
        return executeQuery(
                "Select * from attraction",
                (rs) -> new Person(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type")
                )
        );
    }

}

