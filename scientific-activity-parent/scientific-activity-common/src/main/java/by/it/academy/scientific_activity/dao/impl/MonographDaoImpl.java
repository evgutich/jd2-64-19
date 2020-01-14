package by.it.academy.scientific_activity.dao.impl;

import by.it.academy.scientific_activity.dao.MonographDAO;
import by.it.academy.scientific_activity.publications.Monograph;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MonographDaoImpl extends AbstractDAO implements MonographDAO {

    private static final MonographDaoImpl INSTANCE = new MonographDaoImpl();

    public static final String INSERT_PUBLICATION = "INSERT INTO monograph (type, title, edition, author_id, printRun, pages, entryDate) VALUE (?,?,?,?,?,?,?)";
    public static final String SELECT_PUBLICATION_BY_ID = "SELECT * FROM monograph WHERE id = ?";
    public static final String SELECT_ALL_PUBLICATION = "SELECT * FROM monograph";
    public static final String UPDATE_PUBLICATION = "UPDATE monograph  SET type = ? , title = ?, edition = ?, author_id = ?, printRun = ?, pages = ?, entryDate = ? WHERE id = ?";
    public static final String DELETE_PUBLICATION_BY_ID = "DELETE FROM monograph WHERE id = ?";

    private MonographDaoImpl() {
        super(LoggerFactory.getLogger(MonographDaoImpl.class));
    }

    public static MonographDAO getInstance() {
        return INSTANCE;
    }


    @Override
    public Long create(Monograph monograph) throws SQLException {
        ResultSet resultSet = null;
        Long result = null;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PUBLICATION, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, monograph.getType());
            statement.setString(2, monograph.getTitle());
            statement.setString(3, monograph.getEdition());
            statement.setLong(4, monograph.getAuthorId());
            statement.setInt(5, monograph.getPrintRun());
            statement.setInt(6, monograph.getPages());
            statement.setDate(7, Date.valueOf(monograph.getEntryDate()));
            statement.setLong(8, monograph.getId());

            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                result = resultSet.getLong(1);
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    @Override
    public Optional<Monograph> read(Long id) throws SQLException {
        ResultSet resultSet = null;
        Optional<Monograph> result = Optional.empty();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_PUBLICATION_BY_ID)) {
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = Optional.of(mapMonograph(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    @Override
    public int update(Monograph monograph) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PUBLICATION)) {

            statement.setString(1, monograph.getType());
            statement.setString(2, monograph.getTitle());
            statement.setString(3, monograph.getEdition());
            statement.setLong(4, monograph.getAuthorId());
            statement.setInt(5, monograph.getPrintRun());
            statement.setInt(6, monograph.getPages());
            statement.setDate(7, Date.valueOf(monograph.getEntryDate()));
            statement.setLong(8, monograph.getId());

            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(Long id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PUBLICATION_BY_ID)) {
            statement.setLong(1, id);
            return statement.executeUpdate();
        }
    }

    @Override
    public List<Monograph> getAll() throws SQLException {
        ResultSet resultSet = null;
        List<Monograph> result = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PUBLICATION)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(mapMonograph(resultSet));
            }
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    private Monograph mapMonograph(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String type = resultSet.getString("type");
        String title = resultSet.getString("title");
        String edition = resultSet.getString("edition");
        Long authorId = resultSet.getLong("author_id");
        int printRun = resultSet.getInt("printRun");
        int pages = resultSet.getInt("pages");
        LocalDate entryDate = resultSet.getDate("entryDate").toLocalDate();
        return new Monograph(id, type, title, edition, authorId, printRun, pages, entryDate);
    }
}
