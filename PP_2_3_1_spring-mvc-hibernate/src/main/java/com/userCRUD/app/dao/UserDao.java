package com.userCRUD.app.dao;

import com.userCRUD.app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUserById(long id);

    Optional<User> getUserById(long id);

    public List<User> getAllUsers();

}