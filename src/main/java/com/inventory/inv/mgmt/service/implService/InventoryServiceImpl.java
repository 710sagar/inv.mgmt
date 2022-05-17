package com.inventory.inv.mgmt.service.implService;

import com.inventory.inv.mgmt.model.InventoryModel;
import com.inventory.inv.mgmt.repository.InventoryRepository;
import com.inventory.inv.mgmt.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

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
        if (inventoryRepository.findById(id).isPresent()){
            InventoryModel existingModel = inventoryRepository.findById(id).get();
            existingModel = updateModel(existingModel, model);
            existingModel.setUpdate_date(String.valueOf(calendar.getTime()));
//            existingModel.setQty(model.getQty());
//            existingModel.setDescription(model.getDescription());
//            existingModel.setName(model.getName());
//            existingModel.setPrice(model.getPrice());
//            existingModel.setActive_ind(true);
            inventoryRepository.save(existingModel);
            return existingModel;
        }else{
            return null;
        }
    }

    private InventoryModel updateModel(InventoryModel existingModel, InventoryModel model) {
        if(model.getName() !=null) {
            existingModel.setName(model.getName());
        }

        if(model.getDescription() != null){
            existingModel.setDescription(model.getDescription());
        }

        if (!(model.getQty() <= 0)) {
            existingModel.setQty(model.getQty());
        }

        if(!(model.getPrice() <= 0)) {
            existingModel.setPrice(model.getPrice());
        }
        existingModel.setActive_ind(true);
        return existingModel;
    }

    @Override
    public List<InventoryModel> getAllItems() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional getItemWithGivenId(Long id) {
        return inventoryRepository.findById(id);
    }
}
