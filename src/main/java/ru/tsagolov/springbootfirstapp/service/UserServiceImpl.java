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
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }
    @Transactional(readOnly = true)
    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }
    @Transactional
    @Override
    public void edit (User user) {
        userDao.edit(user);
    }
    @Transactional
    @Override
    public void delete (long id) {
        userDao.delete(id);
    }

}
