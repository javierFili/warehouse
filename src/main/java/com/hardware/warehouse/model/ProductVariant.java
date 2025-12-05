package com.hardware.warehouse.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "product_variants"
)
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productVariantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id",nullable = false)
    @ToString.Exclude
    private Product product;

    @OneToMany(mappedBy = "productVariant",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Stock> stocks;

    private String name;

    @OneToMany(mappedBy = "productVariant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InventoryMovement> inventoryMovements;


}
