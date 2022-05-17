package com.inventory.inv.mgmt.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="inventory_warehouse_mapping")
public class WarehouseMappingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long warehouse_id; //warehouse id FK
    private long stock_id; //inventory id FK
}
