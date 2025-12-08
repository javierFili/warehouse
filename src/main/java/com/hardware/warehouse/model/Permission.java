package com.hardware.warehouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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

    private String codeKey;
    private String description;

    @OneToMany(mappedBy="permission",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<RolePermission> rolePermissions;
}
