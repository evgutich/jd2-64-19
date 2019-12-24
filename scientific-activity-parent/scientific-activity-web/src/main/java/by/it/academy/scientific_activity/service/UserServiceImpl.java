package by.it.academy.scientific_activity.service;

import by.it.academy.scientific_activity.publications.User;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserServiceImpl implements UserService {

    private static final UserServiceImpl INSTANCE = new UserServiceImpl();
    private Map<String, User> users = new ConcurrentHashMap<>();

    private UserServiceImpl() {
        users.put("ivanov", new User("ivanov", "12345", "admin"));
        users.put("petrov", new User("petrov", "12345", "user"));
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> findUser(String login, String password) {
        User user = users.get(login);
        if (user != null && password.equals(user.getPassword())) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}