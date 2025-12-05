package com.hardware.warehouse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "units"
)
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idUnit;

    private String code;
    private String name;
    private String factor_convert;
    

}
