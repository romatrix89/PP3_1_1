package ru.tsagolov.springbootfirstapp.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.tsagolov.springbootfirstapp.model.User;

import java.util.List;

@Repository ("UserDao")
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return em.createNativeQuery("SELECT t.* FROM spring_hiber.users t", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void editUser(User user) {
        User userToBeEdit = getUserById(user.getId());
        userToBeEdit.setFirstName(user.getFirstName());
        userToBeEdit.setLastName(user.getLastName());
        userToBeEdit.setEmail(user.getEmail());
    }

    public void deleteUserById(long id) {
        User userToBeDelete = getUserById(id);
        if (userToBeDelete != null) {
            em.remove(userToBeDelete);
        }
        em.flush();
        em.clear();
    }
}
