package by.it.academy.scientific_activity.dao;

import java.io.Serializable;

public interface DAO<E> {

    E add(E e);

    E update(E e);

    E read(Serializable id);

    void delete(E e);
}
