package com.inventory.inv.mgmt.controller;

import com.inventory.inv.mgmt.model.ApiResponseModel;
import com.inventory.inv.mgmt.model.WarehouseMappingModel;
import com.inventory.inv.mgmt.model.WarehouseModel;
import com.inventory.inv.mgmt.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping(value = "/insertWarehouse")
    public ApiResponseModel insertMapping(@RequestBody WarehouseModel model){ //Insert Warehouse  controller - Send warehouse id and name
        WarehouseModel newModel = warehouseService.saveItem(model);
        return new ApiResponseModel(200,"Inserted",newModel);
    }
}
