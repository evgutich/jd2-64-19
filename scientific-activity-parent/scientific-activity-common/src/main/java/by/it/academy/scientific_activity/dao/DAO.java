package by.it.academy.scientific_activity.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<E> {

    Long create(E e) throws SQLException;

    Optional<E> read(Long id) throws SQLException;

    int update(E e) throws SQLException;

    int delete(E e) throws SQLException;

    List<E> getAll() throws SQLException;
}
