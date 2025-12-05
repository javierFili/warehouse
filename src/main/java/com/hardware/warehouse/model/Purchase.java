package com.hardware.warehouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "purchases"
)
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="supplier_id",nullable = false)
    private Supplier supplier;

    private Date date;

    private Long total;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user",nullable = false)
    private User user;

    @OneToMany(mappedBy = "purchase",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<PurchaseItem> purchaseItems;



}
