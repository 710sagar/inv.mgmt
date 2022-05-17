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
@Table(name="warehouse_table")

public class WarehouseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long warehouse_id;
    private String warehouse_name;
}
