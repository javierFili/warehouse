package com.hardware.warehouse.service;

import com.hardware.warehouse.model.Role;
import com.hardware.warehouse.model.User;
import com.hardware.warehouse.model.UserRole;
import com.hardware.warehouse.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

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
        Stream<UserRole> userRoles = findAllUserRoles().stream().filter(userRole -> {
            return userRole.getUser().getIdUser() == userId && userRole.getRole().getRoleId() == roleId;
        });
        return userRoles.toList();
    }

    // quitamos todos los roles que ya tiene y le re asignamos nuevamente el role
    @Override
    public boolean saveUserRole(Long userId, Long[] roleIds) {
        for (int i = 0; i < roleIds.length; i++) {
            UserRole userRole = new UserRole();
            User user = userService.findUserById(userId).get();
            userRole.setUser(user);
            Role role = roleService.findRoleById(roleIds[i]).get();
            userRole.setRole(role);

            userRoleRepository.save(userRole);
        }
        return true;
    }

}
