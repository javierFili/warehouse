package com.hardware.warehouse.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name="sales"
)
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;
    private String customerName;
    private Date date;
    private Long total;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="warehouse_id",nullable = false)
    private Warehouse warehouse;

    @OneToMany(mappedBy = "sale",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SaleItem> saleItems;
}
