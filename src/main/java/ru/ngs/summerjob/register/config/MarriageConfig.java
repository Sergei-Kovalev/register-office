package ru.ngs.summerjob.register.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.ngs.summerjob.register.dao.PersonDao;

//получение класса через конфигурационный класс (создание бина вручную)

@Configuration
@PropertySource(value = {"classpath:/register.properties"}) // прописываем откуда грузим файл с проперти (может быть массивом ссылок)
public class MarriageConfig {

    @Bean           //можно указать имя
    public PersonDao buildPersonDao() {
        System.out.println("PersonDao is created");
        return new PersonDao();
    }
}
