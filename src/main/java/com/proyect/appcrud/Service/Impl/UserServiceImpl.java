package com.proyect.appcrud.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyect.appcrud.DTO.RequestDTO;
import com.proyect.appcrud.DTO.ResponseDTO;
import com.proyect.appcrud.Entity.User;
import com.proyect.appcrud.Repository.IUserRepository;
import com.proyect.appcrud.Service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public List<ResponseDTO> getAllUsers() {
        List<User> userList = iUserRepository.findAll();
        return userList.stream()
                .map(this::convertUserToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO getUserById(Long id) {
        User user = iUserRepository.getUserById(id);
        return convertUserToResponseDTO(user);
    }

    @Override
    public ResponseDTO createNewUser(RequestDTO requestDTO) {
        User user = new User();
        BeanUtils.copyProperties(requestDTO, user);
        iUserRepository.save(user);
        return convertUserToResponseDTO(user);
    }

    @Override
    public ResponseDTO updateUser(Long id, RequestDTO requestDTO) {
        Optional<User> optionalUser = iUserRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserName(requestDTO.getUserName());
            user.setUserPassword(requestDTO.getUserPassword());
            iUserRepository.save(user);
            return convertUserToResponseDTO(user);
        } else {
            return null; // Usuario no encontrado
        }
    }

    @Override
    public String deleteUser(Long id) {
        User user = iUserRepository.getUserById(id);
        if (user.getId().equals(id)) {
            iUserRepository.delete(user);
            return "Id: " + user.getId() + " " + "Eliminated.";
        }
        return "User not found";
    }

    @Override
    public ResponseDTO convertUserToResponseDTO(User user) {
        ResponseDTO responseDTO = new ResponseDTO();
        BeanUtils.copyProperties(user, responseDTO);
        return responseDTO;
    }
}
