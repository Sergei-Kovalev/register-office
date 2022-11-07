package ru.ngs.summerjob.register.manager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.ngs.summerjob.register.domain.Person;

import java.util.List;

public class PersonManager {

    public static void main(String[] args) {

//        sessionExample();
        
        jpaExample();
    }

    private static void jpaExample() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person p = new Person();
        p.setFirstName("Alexey");
        p.setLastName("Fedorov");
        em.persist(p);
        System.out.println(p.getPersonId());
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        List<Person> from_person = em.createQuery("FROM Person", Person.class).getResultList();
        from_person.forEach(System.out::println);
        em.close();
    }

    private static void sessionExample() {
        SessionFactory sf = buildSessionFactory();

        Session session = sf.openSession();
        session.getTransaction().begin();

        Person p = new Person();
        p.setFirstName("Vasiliy");
        p.setLastName("Sidorov");
//        Long id = (Long) session.save(p);
        session.persist(p);                             //save - deprecated. persist works from hibernate 6.0
        System.out.println(p.getPersonId());

        session.getTransaction().commit();
        session.close();

        session = sf.openSession();
        Person person = session.get(Person.class, p.getPersonId());
        System.out.println("__________________________________________________________________");
        System.out.println(person);
        session.close();

        session = sf.openSession();
        List<Person> from_person = session.createQuery("FROM Person", Person.class).list();
        from_person.forEach(System.out::println);
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
