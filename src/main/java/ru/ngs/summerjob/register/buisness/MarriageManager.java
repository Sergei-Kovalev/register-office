package ru.ngs.summerjob.register.buisness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ngs.summerjob.register.dao.MarriageDao;
import ru.ngs.summerjob.register.dao.PersonDao;
import ru.ngs.summerjob.register.domain.MarriageCertificate;
import ru.ngs.summerjob.register.view.MarriageRequest;
import ru.ngs.summerjob.register.view.MarriageResponse;


@Service
public class MarriageManager {

    private final static Logger LOGGER = LoggerFactory.getLogger(MarriageManager.class);

//    @Autowired  можно в поле
    private MarriageDao marriageDao;
    @Autowired
    private PersonDao personDao;

    @Autowired  // разрабы Spring рекомендуют в конструктор https://habr.com/ru/post/334636/
    public MarriageManager(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

//    @Autowired  можно в сеттер
    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate() called");
        MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);

        return new MarriageResponse();
    }
}
