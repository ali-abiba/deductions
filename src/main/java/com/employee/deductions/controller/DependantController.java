package com.employee.deductions.controller;

import com.employee.deductions.dto.CreateDependantDTO;
import com.employee.deductions.service.dependant.DependantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/dependant")
public class DependantController {

    @Autowired
    DependantService dependantService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createDependant(@RequestBody CreateDependantDTO dependant) {
        dependantService.createDependant(dependant);
        return new ResponseEntity<>("Dependant Created", HttpStatus.OK);
    }
}
