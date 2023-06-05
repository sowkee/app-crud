package com.proyect.appcrud.Service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyect.appcrud.DTO.RequestDTO;
import com.proyect.appcrud.DTO.ResponseDTO;
import com.proyect.appcrud.Entity.User;
import com.proyect.appcrud.Exception.UserNotFoundException;
import com.proyect.appcrud.Repository.IUserRepository;
import com.proyect.appcrud.Service.IUserService;
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
                .map(user -> objectMapper.convertValue(user, ResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO getUserById(Long id) {
        Optional<User> userOptional = iUserRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return convertUserToResponseDTO(user);
        }else {
            throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public ResponseDTO createNewUser(RequestDTO requestDTO) {
        User user = objectMapper.convertValue(requestDTO, User.class);
        iUserRepository.save(user);
        return convertUserToResponseDTO(user);
    }

    @Override
    public ResponseDTO updateUser(Long id, RequestDTO requestDTO) {
        User user = iUserRepository.getUserById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        user.setUserName(requestDTO.getUserName());
        user.setUserPassword(requestDTO.getUserPassword());
        iUserRepository.save(user);
        return convertUserToResponseDTO(user);
    }

    @Override
    public String deleteUser(Long id) {
        Optional<User> userOptional = iUserRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            iUserRepository.delete(user);
            return "Id: " + user.getId() + " " + "Eliminated.";
        }
        return "User not found";
    }

    @Override
    public ResponseDTO convertUserToResponseDTO(User user) {
        return objectMapper.convertValue(user, ResponseDTO.class);
    }
}
