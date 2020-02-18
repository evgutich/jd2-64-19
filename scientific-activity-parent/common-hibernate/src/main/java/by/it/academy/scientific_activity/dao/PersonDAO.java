package by.it.academy.scientific_activity.dao;

import by.it.academy.scientific_activity.entity.Person;

import java.util.Optional;

public interface PersonDAO {

    void create (Person person);

    Optional<Person> read (Long id);

    void update (Person person);

    void delete (Person person);
}
