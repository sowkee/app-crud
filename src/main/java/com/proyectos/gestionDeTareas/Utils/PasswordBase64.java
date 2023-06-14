package com.proyectos.gestionDeTareas.Utils;

import com.proyectos.gestionDeTareas.DTO.UserDTORequest;

import java.util.Base64;

public class PasswordBase64 {

    private String encodePassword(UserDTORequest userDTORequest) {

        try {
            String respuesta = new String(Base64.getEncoder().encode(userDTORequest.getUserPassword().getBytes()));
            return respuesta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
