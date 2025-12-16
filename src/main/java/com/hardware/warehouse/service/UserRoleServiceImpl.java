package com.hardware.warehouse.service;

import com.hardware.warehouse.model.Role;
import com.hardware.warehouse.model.User;
import com.hardware.warehouse.model.UserRole;
import com.hardware.warehouse.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    private final UserService userService;

    private final RoleService roleService;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository,UserService userService,RoleService roleService){
        this.userRoleRepository = userRoleRepository;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public List<UserRole> findAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles;
    }

    @Override
    public Optional<UserRole> findUserRoleById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<UserRole> findUserRoleByUserIdAndRoleId(Long userId, Long roleId) {
        return  userRoleRepository.findByUserIdUser(userId);

    }


    @Transactional
    public boolean saveUserRole(Long userId, Long[] roleIds) {

        List<UserRole> userRoles = userRoleRepository.findByUserIdUser(userId);

        userRoles.forEach(userRole -> {
            userRoleRepository.delete(userRole);
        });

        for (int i = 0; i < roleIds.length; i++) {
            UserRole userRole = new UserRole();
            User user = userService.findUserById(userId)
                            .orElseThrow(()->new RuntimeException("User not found"));
            userRole.setUser(user);
            Role role = roleService.findRoleById(roleIds[i])
                    .orElseThrow(()->new RuntimeException(("Role not found")));
            userRole.setRole(role);

            userRoleRepository.save(userRole);
        }
        return true;
    }

}
