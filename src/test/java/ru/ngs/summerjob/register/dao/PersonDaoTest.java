package ru.ngs.summerjob.register.dao;

import org.junit.jupiter.api.Test;
import ru.ngs.summerjob.register.domain.Person;
import ru.ngs.summerjob.register.domain.PersonFemale;
import ru.ngs.summerjob.register.domain.PersonMale;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonDaoTest {

    @Test
    void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();

        persons.forEach(p -> {
            System.out.println("First name: " + p.getFirstName());
            System.out.println("Class name: " + p.getClass().getName());
            System.out.println("Number of passports: " + p.getPassports().size());
            System.out.println("Birth certificate ???: " + p.getBirthCertificate());
            if (p instanceof PersonMale) {
                System.out.println("Number of Birth certificates: " + ((PersonMale) p).getBirthCertificates().size());
                System.out.println("Number of Marriage certificates: " + ((PersonMale) p).getMarriageCertificates().size());
            } else {
                System.out.println("Number of Birth certificates: " + ((PersonFemale) p).getBirthCertificates().size());
                System.out.println("Number of Marriage certificates: " + ((PersonFemale) p).getMarriageCertificates().size());
            }
        });
    }
}