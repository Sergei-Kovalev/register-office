package ru.ngs.summerjob.register;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ngs.summerjob.register.rest.MarriageController;
import ru.ngs.summerjob.register.view.MarriageRequest;

public class Starter {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
          new String[]{"springContext.xml"}
        );

        MarriageController controller = context.getBean("controller", MarriageController.class);
        controller.findMarriageCertificate(new MarriageRequest());
    }
}
