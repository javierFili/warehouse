package com.hardware.warehouse.service;

import com.hardware.warehouse.model.User;
import com.hardware.warehouse.model.UserRole;
import com.hardware.warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(Long idUser, User user) {
        User userBD = findUserById(idUser)
                .orElseThrow(()->new RuntimeException("User not found"));
        userBD.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setUpdated_at(user.getUpdated_at());
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long idUser) {
        userRepository.deleteById(idUser);
    }

    @Override
    public void changeStatus(Long idUser,String status){
        User userDB = findUserById(idUser)
                .orElseThrow(()->new RuntimeException("User not found"));
        userDB.set_active(status.equals("true")?true:false);
        userRepository.save(userDB);
    }
}
