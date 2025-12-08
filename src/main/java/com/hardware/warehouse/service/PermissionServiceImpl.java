package com.hardware.warehouse.service;

import com.hardware.warehouse.model.Permission;
import com.hardware.warehouse.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> findAllPermissions() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions;
    }

    @Override
    public Optional<Permission> findPermissionById(Long id) {

        return Optional.empty();
    }

    @Override
    public Permission savePermission(Permission permission) {
        return null;
    }

    @Override
    public void updatePermission(Permission permission, Long permissionId) {

    }

    @Override
    public void deletePermission(Long permissionId) {

    }
}
