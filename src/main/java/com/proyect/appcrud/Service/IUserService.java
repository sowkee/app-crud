package com.proyect.appcrud.Service;

import com.proyect.appcrud.DTO.RequestDTO;
import com.proyect.appcrud.DTO.ResponseDTO;
import com.proyect.appcrud.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    ResponseDTO getUserById(Long id);
    List<ResponseDTO> getAllUsers();
    ResponseDTO createNewUser(RequestDTO requestDTO);
    ResponseDTO updateUser(Long id, RequestDTO requestDTO);
    String deleteUser(Long id);

    //Metodo para convertir User a ResponseDTO
    ResponseDTO convertUserToResponseDTO(User user);


}
