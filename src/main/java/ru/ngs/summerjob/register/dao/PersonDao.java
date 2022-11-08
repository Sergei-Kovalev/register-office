package ru.ngs.summerjob.register.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.ngs.summerjob.register.domain.Person;

import java.util.List;

public class PersonDao {
    private final EntityManager entityManager;

    public PersonDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public List<Person> findPersons() {
        return entityManager.createQuery("Select p FROM Person p").getResultList();
    }
}
