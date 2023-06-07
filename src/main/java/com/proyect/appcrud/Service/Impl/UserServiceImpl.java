package com.proyect.appcrud.Service.Impl;

import com.credibanco.dependencia.DTO.RequestDTO;
import com.credibanco.dependencia.DTO.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.proyect.appcrud.Entity.User;
import com.proyect.appcrud.Exception.UserNotFoundException;
import com.proyect.appcrud.Repository.IUserRepository;
import com.proyect.appcrud.Service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.credibanco.dependencia.Utils.AsteriskLogicCard.addAsteristk;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository iUserRepository;
    @Autowired
    ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<ResponseDTO> getAllUsers() {
        try {
            List<User> userList = iUserRepository.findAll();
            return userList.stream()
                    .map(user -> objectMapper.convertValue(user, ResponseDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("An error ocurred.");
        }
        return null;
    }

    @Override
    public ResponseDTO getUserById(long id) {
        Optional<User> userOptional = iUserRepository.findById(id);
        try {
            if(userOptional.isPresent()){
                User user = userOptional.get();
                return convertUserToResponseDTO(user);
            }
        }catch (Exception e) {
            logger.error("User not found");
        }
        return null;
    }

    @Override
    public ResponseDTO createNewUser(RequestDTO requestDTO) {
        try {
            logger.info("Entra al metodo addAsteristk");
            requestDTO.setCardNumber(addAsteristk(requestDTO));
            logger.info("Encode password");
            requestDTO.setUserPassword(encodePassword(requestDTO));
            logger.info("Se mapea");
            User user = objectMapper.convertValue(requestDTO, User.class);
            iUserRepository.save(user);
            return convertUserToResponseDTO(user);
        } catch (Exception e) {
            logger.error("An error ocurred.");
        }
        return  null;
    }

    @Override
    public ResponseDTO updateUser(long id, RequestDTO requestDTO) {
        try {
            User user = iUserRepository.getUserById(id);
            if (user == null) {
                throw new UserNotFoundException("User not found with id: " + id);
            }
            user.setUserName(requestDTO.getUserName());
            user.setUserPassword(requestDTO.getUserPassword());
            iUserRepository.save(user);
            return convertUserToResponseDTO(user);
        } catch (Exception e) {
            logger.error("Error" + e);

        } finally {
            logger.warn("Se finalizo el metodo en la implementacion.");
        }
        return null;
    }

    @Override
    public String deleteUser(long id) {
        try {
            Optional<User> userOptional = iUserRepository.findById(id);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                iUserRepository.delete(user);
                return "Id: " + user.getId() + " " + "Eliminated.";
            }
        } catch (Exception e) {
            logger.error("User not found");
        }
        return null;
    }

    @Override
    public ResponseDTO convertUserToResponseDTO(User user) {
        return objectMapper.convertValue(user, ResponseDTO.class);
    }

    private String encodePassword(RequestDTO requestDTO) {

        try {
          String respuesta = new String(Base64.getEncoder().encode(requestDTO.getUserPassword().getBytes()));
          return respuesta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
