package com.proyect.appcrud.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

@JsonIgnoreProperties
@JsonSerialize
@Component
public class ResponseDTO extends RequestDTO{
}
