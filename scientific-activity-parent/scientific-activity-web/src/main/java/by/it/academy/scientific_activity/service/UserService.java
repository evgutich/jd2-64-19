package by.it.academy.scientific_activity.service;

import by.it.academy.scientific_activity.publications.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUser(String login, String password);
}
