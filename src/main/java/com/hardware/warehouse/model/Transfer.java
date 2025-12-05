package com.hardware.warehouse.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name="transafers"
)
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="warehouse_from_id",nullable = false)
    private Warehouse warehouseFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="warehouse_to_id",nullable = false)
    private Warehouse warehouseTo;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private User user;

    private String status;


}
