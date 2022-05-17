package com.inventory.inv.mgmt.service.implService;

import com.inventory.inv.mgmt.model.WarehouseMappingModel;
import com.inventory.inv.mgmt.repository.MappingRepository;
import com.inventory.inv.mgmt.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingServiceImpl implements MappingService {

    @Autowired
    private MappingRepository mappingRepository;
    @Override
    public WarehouseMappingModel addWarehouseEntry(WarehouseMappingModel model) {
        model = mappingRepository.save(model);
        return model ;
    }
}
