package by.it.academy.scientific_activity.service;

import by.it.academy.scientific_activity.dao.MonographDAO;
import by.it.academy.scientific_activity.dao.impl.MonographDaoImpl;
import by.it.academy.scientific_activity.publications.Monograph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class MonographServiceImpl implements MonographService {

    private static final Logger logger = LoggerFactory.getLogger(MonographServiceImpl.class);

    private static final MonographService INSTANCE = new MonographServiceImpl();

    private final MonographDAO monographDAO = MonographDaoImpl.getInstance();

    public MonographServiceImpl() {
    }

    public static MonographService getService() {
        return INSTANCE;
    }

    @Override
    public List<Monograph> getAllMonograph() {
        try {
            return monographDAO.getAll();
        } catch (SQLException e) {
            logger.error("Error while getting all monographs", e);
        }
        return Collections.emptyList();
    }

    @Override
    public Monograph addNewMonograph(Monograph monograph) {
        logger.debug("add new student {}", monograph);
        try {
            Long id = monographDAO.create(monograph);
            monograph.setId(id);
            logger.debug("result {}", id);
        } catch (SQLException e) {
            logger.error("Error while creating monograph " + monograph, e);
        }
        return monograph;
    }

    @Override
    public void deleteMonograph(Long id) {
        try {
            int delete = monographDAO.delete(id);
            logger.debug("result {}", delete);
        } catch (SQLException e) {
            logger.error("Error while deleting monograph id=" + id, e);
        }
    }

    @Override
    public Monograph updateMonograph(Monograph monograph) {
        logger.debug("updating student {}", monograph);
        try {
            int update = monographDAO.update(monograph);
            logger.debug("result {}", update);
        } catch (SQLException e) {
            logger.error("Error while updating student " + monograph, e);
        }
        return monograph;
    }
}
