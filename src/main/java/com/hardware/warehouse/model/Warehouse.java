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
        name = "warehouses"
)
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;
    private String name;
    private String location;
    private String type;
    private boolean is_active;

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<InventoryMovement> inventoryMovements;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sale> sales;

    @OneToMany(mappedBy = "warehouseFrom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transfer> transfersFrom;

    @OneToMany(mappedBy = "warehouseTo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transfer> transfersTo;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StockAdjustment> stockAdjustments;

}
