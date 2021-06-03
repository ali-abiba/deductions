package com.employee.deductions.controller;

import com.employee.deductions.db.model.Employer;
import com.employee.deductions.dto.CreateEmployerDTO;
import com.employee.deductions.service.employer.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    EmployerService employerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employer> createEmployer(@RequestBody CreateEmployerDTO employer) {
        return new ResponseEntity<>(employerService.createEmployer(employer.getEmployerName()), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employer> getEmployer(@RequestParam("id") int employerId) {
        Employer employer = employerService.getEmployerById(employerId);
        if(employer != null) {
            return new ResponseEntity<>(employer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
