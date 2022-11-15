package ru.ngs.summerjob.register.dao;

import jakarta.persistence.*;
import ru.ngs.summerjob.register.domain.Person;

import java.util.List;

public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findPersons() {
        Query query = entityManager.createNamedQuery("Person.findPersons");
        query.setParameter("personId", 1L);
        return query.getResultList();
    }
}
