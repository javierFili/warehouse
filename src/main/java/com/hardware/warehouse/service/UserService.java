package com.hardware.warehouse.service;

import com.hardware.warehouse.model.User;
import java.util.List;
import java.util.Optional;


public interface UserService {
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    User saveUser(User user);
    void updateUser(Long idUser, User user);
    void changeStatus(Long idUser, String status);
    void deleteUserById(Long idUser);
}
