package com.userCRUD.app.services;

import com.userCRUD.app.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    void updateUser(User user);

    void deleteById(Long id);


}
