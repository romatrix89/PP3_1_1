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
    public void save(User user) {
        em.persist(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return em.createNativeQuery("SELECT t.* FROM spring_hiber.users t", User.class).getResultList();
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void edit(User user) {
        User userToBeEdit = findById(user.getId());
        userToBeEdit.setFirstName(user.getFirstName());
        userToBeEdit.setLastName(user.getLastName());
        userToBeEdit.setEmail(user.getEmail());
    }

    public void delete(long id) {
        User userToBeDelete = findById(id);
        if (userToBeDelete != null) {
            em.remove(userToBeDelete);
        }
        em.flush();
        em.clear();
    }
}
