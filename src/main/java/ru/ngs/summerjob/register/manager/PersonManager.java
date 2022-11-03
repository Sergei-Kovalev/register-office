package ru.ngs.summerjob.register.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.ngs.summerjob.register.domain.Person;

public class PersonManager {

    public static void main(String[] args) {

        SessionFactory sf = buildSessionFactory();

        Session session = sf.openSession();
        session.getTransaction().begin();

        Person p = new Person();
        p.setFirstName("Vasiliy");
        p.setLastName("Sidorov");
//        Long id = (Long) session.save(p);
        session.persist(p);                             //save - deprecated. persist works from hibernate 6.0

        session.getTransaction().commit();
        session.close();

        session = sf.openSession();
        Person person = session.get(Person.class, p.getPersonId());
        System.out.println("__________________________________________________________________");
        System.out.println(person);
        session.close();

        session = sf.openSession();
        session.createQuery("FROM Person"); ///watch this tomorrow
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            Metadata metadata = new MetadataSources(standardRegistry)
                    .getMetadataBuilder()
                    .build();

            return metadata.getSessionFactoryBuilder().build();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

}
