package com.userCRUD.app.dao;

import com.userCRUD.app.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        Optional<User> userById = getUserById(id);
        userById.ifPresent(user -> entityManager.remove(user));
    }
}



