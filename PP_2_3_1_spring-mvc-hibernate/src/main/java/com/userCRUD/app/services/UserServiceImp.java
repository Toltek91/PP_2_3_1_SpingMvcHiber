package com.userCRUD.app.services;

import com.userCRUD.app.dao.UserDAOImpl;
import com.userCRUD.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserDAOImpl userDAO;

    @Autowired
    public UserServiceImp(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.addUser(user);

    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDAO.deleteUserById(id);
    }
}
