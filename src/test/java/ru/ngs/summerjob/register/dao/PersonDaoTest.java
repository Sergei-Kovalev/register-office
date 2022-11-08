package ru.ngs.summerjob.register.dao;

import org.junit.jupiter.api.Test;
import ru.ngs.summerjob.register.domain.Person;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoTest {

    @Test
    void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();

        persons.forEach(p -> {
            System.out.println(p.getFirstName());
            System.out.println(p.getClass().getName());
            System.out.println(p.getPassports().size());
        });
    }
}