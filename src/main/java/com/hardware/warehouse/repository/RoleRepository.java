package com.hardware.warehouse.repository;

import com.hardware.warehouse.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
