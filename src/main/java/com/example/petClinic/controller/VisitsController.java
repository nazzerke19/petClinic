package com.example.petClinic.controller;

import com.example.petClinic.model.Owner;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class VisitsController {
    Owner owner1 = new Owner();


}
