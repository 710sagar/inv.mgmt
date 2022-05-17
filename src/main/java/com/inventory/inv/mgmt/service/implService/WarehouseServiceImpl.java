package com.inventory.inv.mgmt.service.implService;

import com.inventory.inv.mgmt.model.WarehouseModel;
import com.inventory.inv.mgmt.repository.WarehouseRepository;
import com.inventory.inv.mgmt.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;
    @Override
    public WarehouseModel saveItem(WarehouseModel model) {
        model = warehouseRepository.save(model);
        return model ;
    }
}
