package com.proyectos.gestionDeTareas.Controller;


import com.proyectos.gestionDeTareas.Service.ITaskService;
import com.proyectos.gestionDeTareas.Service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("tasks")
public class ExpensesController {

    Logger logger = LoggerFactory.getLogger(ExpensesController.class);

    @Autowired
    ITaskService iTaskService;



}
