package com.proyectos.gestionDeTareas.Controller;

import com.proyectos.gestionDeTareas.DTO.UserDTORequest;
import com.proyectos.gestionDeTareas.DTO.UserDTOResponse;
import com.proyectos.gestionDeTareas.Service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService iUserService;

    @GetMapping("get/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUsersById (@PathVariable  long id) {
        Map<String, Object> res = new HashMap<>();
        UserDTOResponse response = iUserService.getUserById(id);
        if (response == null) {
            res.put("status", HttpStatus.BAD_REQUEST);
            res.put("message", "User not found");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        res.put("status", HttpStatus.OK);
        res.put("data", response);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("get/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        Map<String, Object> res = new HashMap<>();
        List<UserDTOResponse> listResponseDto = this.iUserService.getAllUsers();
        res.put("status", HttpStatus.OK);
        res.put("data", listResponseDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createNewUser(UserDTORequest userDTORequest) {
        Map<String, Object> res = new HashMap<>();
        UserDTOResponse response = this.iUserService.createNewUser(userDTORequest);

        res.put("status", HttpStatus.CREATED);
        res.put("data", response);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateUser () {

    }
}
