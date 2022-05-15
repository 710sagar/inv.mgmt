package com.inventory.inv.mgmt.controller;

import com.inventory.inv.mgmt.Constants;
import com.inventory.inv.mgmt.model.ApiResponseModel;
import com.inventory.inv.mgmt.model.InventoryModel;
import com.inventory.inv.mgmt.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping(value="/hello")
    public String getHello(){
        return "Hello this is service";
    }

    @PostMapping(value = "/saveItem")
    public ApiResponseModel save(@RequestBody InventoryModel model) {
        ApiResponseModel api = new ApiResponseModel();
        try {
            InventoryModel result = inventoryService.saveItem(model);
            log.info("Model saved "+result.toString());
            if(result!=null){
                api.setStatusCode(Constants.HTTP_CREATED);
                api.setMessage("created!");
                api.setData(result);
                return api;
            }
        } catch (Exception ex) {
            ex.getStackTrace();}
//        } finally {
//            api.setStatusCode(Constants.HTTP_INTERNAL_SERVER_ERROR);
//            api.setMessage("Some error occurred. see logs for stacktrace.");
//            return api;
//        }
        return api;
    }

    @GetMapping(value = "/delete/{itemId}")
    @ResponseBody
    public ApiResponseModel deleteItemById(@PathVariable("itemId") Long id){
        ApiResponseModel apiResponseModel = new ApiResponseModel();
        String result = inventoryService.deleteItemWithGivenId(id);
        if(result == null){
            apiResponseModel.setStatusCode(Constants.HTTP_NOT_FOUND);
            apiResponseModel.setMessage("Data not found");
            return apiResponseModel;
        }
        apiResponseModel.setStatusCode(Constants.HTTP_OK);
        apiResponseModel.setMessage("item with ID " + id + " found in database");
        apiResponseModel.setData(result);
        return apiResponseModel;
    }



    @PutMapping(value = "/edit/{itemId}")
    public ApiResponseModel editItemById(@PathVariable("itemId") Long id, @RequestBody InventoryModel model){
        ApiResponseModel apiResponseModel = new ApiResponseModel();
        InventoryModel result = inventoryService.editItemWithGivenId(id, model);
        if(result == null){
            apiResponseModel.setStatusCode(Constants.HTTP_NOT_FOUND);
            apiResponseModel.setMessage("Data not found");
            return apiResponseModel;
        }
        apiResponseModel.setStatusCode(Constants.HTTP_OK);
        apiResponseModel.setMessage("items with ID " + id + " updated");
        apiResponseModel.setData(result);
        return apiResponseModel;
    }
}
