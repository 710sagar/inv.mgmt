package com.inventory.inv.mgmt.service.implService;

import com.inventory.inv.mgmt.model.InventoryModel;
import com.inventory.inv.mgmt.repository.InventoryRepository;
import com.inventory.inv.mgmt.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public InventoryModel saveItem(InventoryModel model){
        Calendar calendar = Calendar.getInstance();
        model.setCreate_date(String.valueOf(calendar.getTime()));
        model.setUpdate_date(String.valueOf(calendar.getTime()));
        model.setActive_ind(true);
        inventoryRepository.save(model);
        return model;
    }

    public String deleteItemWithGivenId(Long id){
        inventoryRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public InventoryModel editItemWithGivenId(Long id, InventoryModel model){
        Calendar calendar = Calendar.getInstance();
        model.setUpdate_date(String.valueOf(calendar.getTime()));

        if (inventoryRepository.findById(id).isPresent()){
            InventoryModel existingInventory = inventoryRepository.findById(id).get();

            existingInventory.setUpdate_date(String.valueOf(calendar.getTime()));
            existingInventory.setQty(model.getQty());
            existingInventory.setDescription(model.getDescription());
            existingInventory.setName(model.getName());
            existingInventory.setPrice(model.getPrice());
            existingInventory.setActive_ind(true);
            existingInventory.setWarehouse_id(model.getWarehouse_id());

            inventoryRepository.save(existingInventory);

            return model;
        }else{
            return null;
        }
    }
}
