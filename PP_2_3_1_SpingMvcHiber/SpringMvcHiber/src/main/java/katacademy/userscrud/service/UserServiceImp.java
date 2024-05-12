package katacademy.userscrud.service;


import katacademy.userscrud.dao.UserDaoImpl;
import katacademy.userscrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserDaoImpl userDAO;

    @Autowired
    public UserServiceImp(UserDaoImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);

    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);

    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userDAO.deleteUserById(id);

    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
