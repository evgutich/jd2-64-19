package by.it.academy.scientific_activity.listener;

import by.it.academy.scientific_activity.db.connection.pool.SADataSource;
import by.it.academy.scientific_activity.db.migration.DbMigration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import java.util.ResourceBundle;

@WebListener()
public class ScientificActivityContextInitListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(ScientificActivityContextInitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Context initialized");
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("mysql_hikari");
            SADataSource.configure(bundle);
            DataSource dataSource = SADataSource.getDataSource();
            DbMigration.migrate(dataSource);
        } catch (Exception e) {
            logger.error("error ", e);
            throw new RuntimeException("Datasource initialisation error ", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Context destroyed");
    }
}
