package katacademy.userscrud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import katacademy.userscrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
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

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(long id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
