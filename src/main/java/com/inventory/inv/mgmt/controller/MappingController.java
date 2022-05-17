package com.inventory.inv.mgmt.controller;

import com.inventory.inv.mgmt.model.ApiResponseModel;
import com.inventory.inv.mgmt.model.WarehouseMappingModel;
import com.inventory.inv.mgmt.repository.MappingRepository;
import com.inventory.inv.mgmt.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    @Autowired
    private MappingService mappingService;

    @PostMapping(value = "/insertMapping")
    public ApiResponseModel insertMapping(@RequestBody WarehouseMappingModel model){ //Insert Warehouse mapping controller Send stock id and warehouse id
        WarehouseMappingModel newModel = mappingService.addWarehouseEntry(model);
        return new ApiResponseModel(200,"Inserted",newModel);
    }


}
