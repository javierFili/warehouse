package com.hardware.warehouse.repository;

import com.hardware.warehouse.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
