package com.inventory.inv.mgmt.repository;

import com.inventory.inv.mgmt.model.WarehouseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseModel,Long> {
}
