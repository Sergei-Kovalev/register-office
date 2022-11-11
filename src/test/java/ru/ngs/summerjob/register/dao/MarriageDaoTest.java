package ru.ngs.summerjob.register.dao;

import org.junit.jupiter.api.Test;
import ru.ngs.summerjob.register.domain.MarriageCertificate;
import ru.ngs.summerjob.register.view.MarriageRequest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MarriageDaoTest {

    @Test
    void findMarriageCertificate() {
        MarriageDao dao = new MarriageDao();
        MarriageRequest request = new MarriageRequest();
        request.setMarriageCertificateNumber("321 Marriage");
        request.setMarriageCertificateDate(LocalDate.of(2017, 1, 1));
        request.setHusbandGivenName("Oleg");
        request.setHusbandSurname("Kasatkin");
        request.setHusbandPatronymic("Petrovich");
        request.setWifeGivenName("Elena");
        request.setWifeSurname("Kasatkina");
        request.setWifePatronymic("Sergeevna");

        MarriageCertificate certificate = dao.findMarriageCertificate(request);

        System.out.println(certificate.getMarriageCertificateId());
    }
}