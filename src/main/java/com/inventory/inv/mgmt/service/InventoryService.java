package com.inventory.inv.mgmt.service;

import com.inventory.inv.mgmt.model.InventoryModel;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    public InventoryModel saveItem(InventoryModel model);

    String deleteItemWithGivenId(Long id);

    public InventoryModel editItemWithGivenId(Long id, InventoryModel model);

    List<InventoryModel> getAllItems();

    Optional getItemWithGivenId(Long id);
}
