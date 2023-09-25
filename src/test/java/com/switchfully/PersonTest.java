package com.switchfully;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void name() {
        Person person = new Person(1, "firstName", "lastName");
        Assertions.assertThat(person.lastName()).isEqualTo("lastName");
    }
}
