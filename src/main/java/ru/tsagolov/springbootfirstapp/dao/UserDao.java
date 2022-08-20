package ru.tsagolov.springbootfirstapp.dao;

import ru.tsagolov.springbootfirstapp.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> allUsers();

    User findUserById(long id);

    void edit(User user);
    void delete (long id);
}
