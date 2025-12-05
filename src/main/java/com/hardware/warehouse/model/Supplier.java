package com.hardware.warehouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "suppliers"
)
public class Supplier{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;
    private String name;
    private String contact;
    private String phone;
    private String email;


    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Purchase> purchases;
}
