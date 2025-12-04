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
        name = "stock_batches"
)
public class StockBatche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockBatcheId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="producto_batches_id",nullable = false)
    private ProductBatche productBatche;

    private Float quantity;

    @OneToMany(mappedBy = "stockBatche",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<InventoryMovement> inventoryMovements;

}
