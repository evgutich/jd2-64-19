package by.it.academy.scientific_activity;

import static org.junit.Assert.assertTrue;

import by.it.academy.scientific_activity.entity.Person;
import by.it.academy.scientific_activity.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.EntityManager;

public class AppTest 
{
    @Test
    public void saveTest() {

        EntityManager entityManager = HibernateUtil.getEntityManager();
        Person person = new Person(null, "Daniil", "Kastylenka", 20);

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(person);
            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();
            Person personFromDB = entityManager.find(Person.class, person.getId());

            Assert.assertEquals(person, personFromDB);

        } catch (HibernateException e){
            entityManager.getTransaction().rollback();

        } finally {
            entityManager.close();
        }
    }

    @AfterClass
    public static void afterClass() throws Exception {
        HibernateUtil.close();
    }
}
