package com.switchfully;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class PersonRepositoryTest {

    @Inject
    PersonRepository personRepository;

    @Test
    void name() {
        Assertions.assertThat(personRepository.findAll()).contains(new Person(1, "The Eiffel Tower","MONUMENT"));
    }
}
