package ru.ngs.summerjob.register.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ngs.summerjob.register.domain.MarriageCertificate;
import ru.ngs.summerjob.register.view.MarriageRequest;

public class MarriageDao {
    private EntityManager entityManager;

    public MarriageDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    private final static Logger LOGGER = LoggerFactory.getLogger(MarriageDao.class);

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {

        LOGGER.info("findMarriageCertificate() called");

        Query query = entityManager.createQuery("MarriageCertificate.findMarriageCertificate");
        query.setParameter();
        return new MarriageCertificate();
    }
}
