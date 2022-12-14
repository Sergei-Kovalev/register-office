package ru.ngs.summerjob.register.dao;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.ngs.summerjob.register.domain.MarriageCertificate;
import ru.ngs.summerjob.register.view.MarriageRequest;


@Component
public class MarriageDao {
    private EntityManager entityManager;

    @Value("${test.value}")
    private String test;

    public void setTest(String test) {
        this.test = test;
    }
/*

    public MarriageDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }
*/

    private final static Logger LOGGER = LoggerFactory.getLogger(MarriageDao.class);

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) {

        LOGGER.info("findMarriageCertificate() called: {}", test);
/*
        Query query = entityManager.createQuery("MarriageCertificate.findMarriageCertificate");
        query.setParameter("marriageCertificateNumber", request.getMarriageCertificateNumber());
        query.setParameter("marriageCertificateDate", request.getMarriageCertificateDate());
        query.setParameter("husbandSurname", request.getHusbandSurname());
        query.setParameter("husbandGivenName", request.getHusbandGivenName());
        query.setParameter("husbandPatronymic", request.getHusbandPatronymic());
        query.setParameter("wifeSurname", request.getWifeSurname());
        query.setParameter("wifeGivenName", request.getWifeGivenName());
        query.setParameter("wifePatronymic", request.getWifePatronymic());
        List<MarriageCertificate> resultList = query.getResultList();*/
        return null;
    }
}
