package com.hardware.warehouse.repository;

import com.hardware.warehouse.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByUserIdUser(Long userIdUser);
}
