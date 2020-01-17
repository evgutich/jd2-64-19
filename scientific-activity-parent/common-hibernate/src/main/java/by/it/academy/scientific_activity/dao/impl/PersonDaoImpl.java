package by.it.academy.scientific_activity.dao.impl;

import by.it.academy.scientific_activity.dao.PersonDAO;
import by.it.academy.scientific_activity.entity.Person;
import by.it.academy.scientific_activity.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Optional;

@Slf4j
public class PersonDaoImpl implements PersonDAO {

    private static final PersonDaoImpl INSTANCE = new PersonDaoImpl();

    @Override
    public void create(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("error while creating person", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Person> read(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            return Optional.ofNullable(person);
        } catch (Exception e) {
            log.error("error while reading person", e);
        } finally {
            session.close();
        }
        return Optional.empty();
    }

    @Override
    public void update(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error while updating person", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error while deleting person", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    public static PersonDaoImpl getInstance() {
        return INSTANCE;
    }
}
