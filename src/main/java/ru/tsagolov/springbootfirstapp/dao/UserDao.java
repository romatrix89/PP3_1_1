package ru.tsagolov.springbootfirstapp.dao;

import ru.tsagolov.springbootfirstapp.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    void editUser (User user);
    void deleteUserById (long id);
}
