package com.hardware.warehouse.service;

import com.hardware.warehouse.model.Role;
import com.hardware.warehouse.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @Override
    public Optional<Role> findRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void updateRole(Role role) {

    }

    @Override
    public void deleteRoleById(Long id) {

    }
}
