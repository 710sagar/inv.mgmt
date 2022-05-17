package com.inventory.inv.mgmt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseModel {
    private int statusCode ;
    private String message ;
    private Object data ;
}
