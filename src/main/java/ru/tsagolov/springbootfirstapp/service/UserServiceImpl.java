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
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public User findById(long id) {
        return userDao.findById(id);
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
