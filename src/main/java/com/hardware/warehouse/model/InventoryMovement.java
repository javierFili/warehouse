package com.hardware.warehouse.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "inventory_movements"
)
public class InventoryMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryMovementId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id",nullable = false)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_variant_id",nullable = true)
    private ProductVariant productVariant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_batch_id",nullable = true)
    private StockBatche stockBatche;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_serial_id",nullable = true)
    private ProductSerial productSerial;

    private String type;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "reference_id",nullable = true)
//    private
    private Long quantity;

    private int unit_cost;

    private Long total_cost;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private String note;

}
