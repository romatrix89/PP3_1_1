package ru.tsagolov.springbootfirstapp.service;

import ru.tsagolov.springbootfirstapp.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> allUsers();

    User findUserById (long id);

    void edit (User user);

    void delete (long id);
}
