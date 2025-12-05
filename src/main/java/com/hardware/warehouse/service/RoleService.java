package com.hardware.warehouse.service;

import com.hardware.warehouse.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAllRoles();
    Optional<Role> findRoleById(Long id);
    Role saveRole(Role role);
    void updateRole(Role role);
    void deleteRoleById(Long id);
}
