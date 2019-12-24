package by.it.academy.scientific_activity.dao.impl;

import by.it.academy.scientific_activity.db.connection.pool.SADataSource;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class AbstractDAO {
    protected final Logger logger;

    protected AbstractDAO(Logger logger) {
        this.logger = logger;
    }

    protected Connection getConnection() throws SQLException{
        return SADataSource.getConnection();
    }

    protected void closeQuietly(AutoCloseable closeable){
        try {
            if (closeable != null){
                closeable.close();
            }
        } catch (Exception e) {
            logger.error("Error while closing closable: " + closeable, e);
        }
    }
}
