package com.hardware.warehouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "product_batches"
)
public class ProductBatche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productBatcheId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id",nullable = false)
    private  Product product;

    private String batchNumber;
    private Date expiration_date;
    private Float purchase_price;
    private String status;

    @OneToMany(mappedBy = "productBatche",cascade = CascadeType.ALL)
    private List<StockBatche> stockBatches;

    @OneToMany(mappedBy = "productBatche", cascade = CascadeType.ALL)
    private List<PurchaseItem> purchaseItems;

    @OneToMany(mappedBy = "productBatche", cascade = CascadeType.ALL)
    private List<SaleItem> saleItems;
}
