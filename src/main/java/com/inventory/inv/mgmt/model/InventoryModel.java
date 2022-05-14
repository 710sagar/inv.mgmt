package com.inventory.inv.mgmt.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
@Table(name="stock_table")
public class InventoryModel {
    private long id;
    private String name;
    private String desc;
    private double price;

}
