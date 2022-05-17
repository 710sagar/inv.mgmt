package com.inventory.inv.mgmt.repository;

import com.inventory.inv.mgmt.model.WarehouseMappingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingRepository extends JpaRepository<WarehouseMappingModel,Long> {
}
