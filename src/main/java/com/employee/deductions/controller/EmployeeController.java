package com.employee.deductions.controller;

import com.employee.deductions.db.model.Employee;
import com.employee.deductions.dto.CreateEmployeeDTO;
import com.employee.deductions.dto.EmployeeTableDTO;
import com.employee.deductions.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createEmployee(@RequestBody CreateEmployeeDTO employee) {
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Employee Created", HttpStatus.OK);
    }

    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@RequestParam("id") int id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/salary-after-deductions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Double> getSalaryAfterDeductions(@RequestParam("id") int id) {
        return new ResponseEntity<>(employeeService.getSalaryAfterDeductions(id), HttpStatus.OK);
    }

    @GetMapping(path = "/table-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTableDTO>> getEmployeeTableData(@RequestParam("id") int id) {
        return new ResponseEntity<>(employeeService.getEmployeeTableData(id), HttpStatus.OK);
    }

    @PostMapping(path = "/delete", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
        return new ResponseEntity<>("Employee Deleted", HttpStatus.OK);
    }
}
