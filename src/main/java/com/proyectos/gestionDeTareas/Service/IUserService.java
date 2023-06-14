package com.proyectos.gestionDeTareas.Service;

import com.proyectos.gestionDeTareas.DTO.UserDTORequest;
import com.proyectos.gestionDeTareas.DTO.UserDTOResponse;
import com.proyectos.gestionDeTareas.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    UserDTOResponse getUserById(long id);
    List<UserDTOResponse> getAllUsers();
    UserDTOResponse createNewUser(UserDTORequest userDTORequest);
    UserDTOResponse updateUser(long id, UserDTORequest userDTORequest);
    String deleteUser(long id);
    UserDTOResponse convertUserToResponseDTO(User user);
}
