package com.inventory.inv.mgmt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @GetMapping(value="/hello")
    public String getHello(){
        return "Hello this is service";
    }
}
