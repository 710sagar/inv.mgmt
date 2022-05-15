package com.inventory.inv.mgmt.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ApiResponseModel {
    private int statusCode ;
    private String message ;
    private Object data ;
}
