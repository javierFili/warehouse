package com.hardware.warehouse.repository;

import com.hardware.warehouse.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
}
