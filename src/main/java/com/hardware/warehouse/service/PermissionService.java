package com.hardware.warehouse.service;

import com.hardware.warehouse.model.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {
    List<Permission> findAllPermissions();
    Optional<Permission> findPermissionById(Long id);
    Permission savePermission(Permission permission);
    void updatePermission(Permission permission,Long permissionId);
    void deletePermission(Long permissionId);

}
