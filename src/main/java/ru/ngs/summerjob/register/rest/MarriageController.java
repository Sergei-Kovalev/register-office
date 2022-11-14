package ru.ngs.summerjob.register.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ngs.summerjob.register.buisness.MarriageManager;
import ru.ngs.summerjob.register.view.MarriageRequest;
import ru.ngs.summerjob.register.view.MarriageResponse;


@Service("controller")
public class MarriageController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MarriageController.class);

    @Autowired
    private MarriageManager marriageManager;

    public void setMarriageManager(MarriageManager marriageManager) {
        this.marriageManager = marriageManager;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate() called");
        return marriageManager.findMarriageCertificate(request);
    }
}
