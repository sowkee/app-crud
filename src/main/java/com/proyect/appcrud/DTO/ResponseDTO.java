package com.proyect.appcrud.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;


@Component
public class ResponseDTO extends RequestDTO{
    @JsonIgnore
    private String userPassword;
}
