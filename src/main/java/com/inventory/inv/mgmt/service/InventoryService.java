package com.inventory.inv.mgmt.service;

import com.inventory.inv.mgmt.model.InventoryModel;

public interface InventoryService {
    public InventoryModel saveItem(InventoryModel model);

    String deleteItemWithGivenId(Long id);

    public InventoryModel editItemWithGivenId(Long id, InventoryModel model);
}
