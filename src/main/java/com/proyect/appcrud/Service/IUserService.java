package com.proyect.appcrud.Service;

import com.credibanco.dependencia.DTO.RequestDTO;
import com.credibanco.dependencia.DTO.ResponseDTO;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.proyect.appcrud.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    ResponseDTO getUserById(long id);
    List<ResponseDTO> getAllUsers();
    ResponseDTO createNewUser(RequestDTO requestDTO);
    ResponseDTO updateUser(long id, RequestDTO requestDTO);
    String deleteUser(long id);

    //Metodo para convertir User a ResponseDTO
    ResponseDTO convertUserToResponseDTO(User user);


}
