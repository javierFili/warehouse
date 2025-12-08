package com.hardware.warehouse.service;

import com.hardware.warehouse.model.User;
import com.hardware.warehouse.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {
    List<UserRole> findAllUserRoles();
    Optional<UserRole> findUserRoleById(Long id);
    boolean saveUserRole(Long userId, Long [] userRoleIds);
    List<UserRole> findUserRoleByUserIdAndRoleId(Long userId, Long roleId);
}
