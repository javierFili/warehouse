package com.hardware.warehouse.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "product_serials"
)
public class ProductSerial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productSerialId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id",nullable = false)
    private Product product;

    private String serialNumber;
    private String status;

    @OneToMany(mappedBy = "productSerial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InventoryMovement> inventoryMovements;

    @OneToMany(mappedBy = "productSerial",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SaleItem> saleItems;
}
