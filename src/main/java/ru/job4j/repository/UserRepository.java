package ru.job4j.repository;

import ru.job4j.toone.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> add(User user);
    Optional<User> findUserByLoginAndPassword(String login, String password);
}
