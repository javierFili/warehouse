package com.hardware.warehouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name= "permissions"
)
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    private String key;
    private String description;

    @OneToMany(mappedBy="permission",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<RolePermission> rolePermissions;
}
