package ru.tsagolov.springbootfirstapp.dao;

import ru.tsagolov.springbootfirstapp.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    List<User> findAll();

    User findById(long id);

    void edit(User user);
    void delete (long id);
}
