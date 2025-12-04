package com.hardware.warehouse.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
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
    private Product product;

    @OneToMany(mappedBy = "productVariant",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Stock> stocks;

    private String name;

    @OneToMany(mappedBy = "productVariant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InventoryMovement> inventoryMovements;


}
