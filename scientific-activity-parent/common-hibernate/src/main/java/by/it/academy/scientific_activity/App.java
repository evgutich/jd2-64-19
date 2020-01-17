package by.it.academy.scientific_activity;

import by.it.academy.scientific_activity.dao.PersonDAO;
import by.it.academy.scientific_activity.dao.impl.PersonDaoImpl;
import by.it.academy.scientific_activity.embedded.Address;
import by.it.academy.scientific_activity.entity.Person;
import by.it.academy.scientific_activity.util.HibernateUtil;

import java.util.Optional;

public class App {

    private static final PersonDAO personDAO = PersonDaoImpl.getInstance();

    public static void main(String[] args) {

        Person person = new Person(null, "Igor", "Ivanov", null, 25, new Address("Sadovaya", "Minsk", "225215"));
        personDAO.create(person);

        Optional<Person> personFromDB = personDAO.read(1L);

        Person personForUpdate = new Person(1L, "Stepan", "Razin", null, 25, new Address("Sadovaya", "Minsk", "225215"));
        personDAO.update(personForUpdate);

        personDAO.delete(person);

        HibernateUtil.shutDown();
    }
}
