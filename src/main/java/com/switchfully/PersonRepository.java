package com.switchfully;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PersonRepository extends AbstractRepository {

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

