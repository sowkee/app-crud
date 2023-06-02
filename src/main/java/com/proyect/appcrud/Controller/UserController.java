package com.proyect.appcrud.Controller;


import com.proyect.appcrud.DTO.RequestDTO;
import com.proyect.appcrud.DTO.ResponseDTO;
import com.proyect.appcrud.Entity.User;
import com.proyect.appcrud.Service.IUserService;
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

    @Autowired
    IUserService iUserService;
    @Autowired
    ResponseDTO responseDTO;

    @GetMapping("get/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllUsers () {
        Map<String, Object> res = new HashMap<>();

        List<ResponseDTO> listResponseDTO = this.iUserService.getAllUsers();
        res.put("status", HttpStatus.OK);
        res.put("data", listResponseDTO);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUsersById (@PathVariable  Long id) {
        Map<String, Object> res = new HashMap<>();
        ResponseDTO response = iUserService.getUserById(id);
        if (response.getId().equals(id)) {
            res.put("status", HttpStatus.OK);
            res.put("data", response);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        res.put("status", HttpStatus.NOT_FOUND);
        res.put("data", response);
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @PostMapping("create")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> createNewUser(@RequestBody RequestDTO requestDTO) {
        Map<String, Object> res = new HashMap<>();
        ResponseDTO response = this.iUserService.createNewUser(requestDTO);
        System.out.println("@@@@@@" + response);
        res.put("status", HttpStatus.CREATED);
        res.put("data", response);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable Long id, @RequestBody RequestDTO requestDTO) {
        Map<String, Object> res = new HashMap<>();
        ResponseDTO response = this.iUserService.updateUser(id, requestDTO);
        if (response != null){
            res.put("status", HttpStatus.OK);
            res.put("data", response);
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        res.put("status", HttpStatus.NOT_FOUND);
        res.put("message", "Fail.");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Long id) {
        Map<String, Object> res = new HashMap<>();
        String respuesta = this.iUserService.deleteUser(id);
        res.put("status", HttpStatus.OK);
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
