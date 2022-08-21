package ru.tsagolov.springbootfirstapp.service;

import ru.tsagolov.springbootfirstapp.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> findAll();

    User findById (long id);

    void edit (User user);

    void delete (long id);
}
