package com.lambdaschool.crudyrestaurants.controllers;

import com.lambdaschool.javaorders.models.Agents
import com.lambdaschool.javaorders.services.
import com.lambdaschool.crudyrestaurants.views.MenuCounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/agents")
public class AgentsController {
    @Autowired
    private AgentsServices agentsServices;


    //http://localhost:2019/agents
    //http://localhost:2019/restaurants/restaurants
    //http://localhost:2019/restaurants/restaurants










}
