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

        MarriageController controller = context.getBean(MarriageController.class);                      //можно не использовать имя так как класс ток 1
//        MarriageController controller = context.getBean("controller", MarriageController.class);      //удобно если это интерфейс с несколькими имплементациями
        controller.findMarriageCertificate(new MarriageRequest());
    }
}
