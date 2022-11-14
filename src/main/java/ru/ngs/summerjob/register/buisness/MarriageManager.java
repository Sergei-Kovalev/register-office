package ru.ngs.summerjob.register.buisness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ngs.summerjob.register.dao.MarriageDao;
import ru.ngs.summerjob.register.domain.MarriageCertificate;
import ru.ngs.summerjob.register.view.MarriageRequest;
import ru.ngs.summerjob.register.view.MarriageResponse;

public class MarriageManager {

    private final static Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);

    private MarriageDao marriageDao;

    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate() called");
        MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);

        return new MarriageResponse();
    }
}
