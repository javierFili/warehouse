package com.hardware.warehouse.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter // crear un get para todos los atributos de la entidad
@Setter // crea un set para todos los atributos de la entidad
@AllArgsConstructor // Genera un contructor con todos los atributos de la clase
@NoArgsConstructor // Geenra un contructor vacio( sin parametros)
@Entity
// jpa, se marca una clases como entidad de base de datos, la clase corresponde a una tabla, debe tener el @id, cada atributo es una columna
@Table(
        name = "users"
) // configura el nombre y propiedades de la tabla
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String email;
    private String name;
    private String lastName;
    private String password;
    private boolean is_active;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Purchase> purchases;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sale> sales;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transfer> transfers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StockAdjustment> stockAdjustments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserRole> userRoles;

    public boolean getIsActive() {
        return is_active;
    }

    public List<Long> getRoleIds() {
        List<Long> rolesId = new ArrayList<>();

        userRoles.stream().forEach(userRole -> {
            rolesId.add(userRole.getRole().getRoleId());
        });
        return rolesId;
    }

    public List<Long> getPermissionIds() {
        List<Long> permissionIds = new ArrayList<>();
        userRoles.stream().forEach(userRole -> {
            userRole.getRole().getRolePermissions().stream().forEach(rolePermission -> {
                permissionIds.add(rolePermission.getPermission().getPermissionId());
            });
        });
        return permissionIds;
    }

}
