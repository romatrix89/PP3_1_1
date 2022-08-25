package ru.tsagolov.springbootfirstapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsagolov.springbootfirstapp.dao.UserDao;
import ru.tsagolov.springbootfirstapp.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional(readOnly = true)
    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
    @Transactional
    @Override
    public void editUser (User user) {
        userDao.editUser(user);
    }
    @Transactional
    @Override
    public void deleteUserById (long id) {
        userDao.deleteUserById(id);
    }

}
