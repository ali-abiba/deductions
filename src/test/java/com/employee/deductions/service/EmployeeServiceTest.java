package com.employee.deductions.service;

import com.employee.deductions.db.model.Dependant;
import com.employee.deductions.db.model.Employee;
import com.employee.deductions.db.model.Employer;
import com.employee.deductions.db.repository.EmployeeRepository;
import com.employee.deductions.db.repository.EmployerRepository;
import com.employee.deductions.dto.CreateEmployeeDTO;
import com.employee.deductions.service.employee.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl sut;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployerRepository employerRepository;

    @Test
    public void testCreateEmployee(){
        CreateEmployeeDTO createEmployeeDTO = new CreateEmployeeDTO();
        createEmployeeDTO.setFirstName("Oda");
        createEmployeeDTO.setLastName("Nobunaga");
        createEmployeeDTO.setEmployerId(1);

        when(employerRepository.findById(any())).thenReturn(Optional.of(new Employer(1, "Bill", new ArrayList<>())));
        sut.createEmployee(createEmployeeDTO);

        verify(employeeRepository).save(any());
    }

    @Test
    public void testCreateEmployeeInvalidEmployer() {
        Assertions.assertThrows(ResponseStatusException.class, () -> {
            sut.createEmployee(buildEmployeeDto());
        });
    }

    @Test
    public void testGetEmployeeById() {
        when(employeeRepository.findById(any())).thenReturn(Optional.of(new Employee()));
        sut.getEmployeeById(1);
        verify(employeeRepository).findById(any());
    }

    @Test
    public void testGetEmployeeNull() {
        Assertions.assertThrows(ResponseStatusException.class, () -> {
            sut.getEmployeeById(1);
        });
    }

    @Test
    public void testGetSalaryAfterDeductionsNoDiscounts() {
        Employee employee = new Employee();
        employee.setSalary(4000L);
        employee.setFirstName("Ashina Moritaka");
        Dependant dependant1 = new Dependant();
        dependant1.setFirstName("Morikiyo");
        Dependant dependant2 = new Dependant();
        dependant2.setFirstName("Moriuji");

        employee.setDependants(Arrays.asList(dependant1, dependant2));

        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(employee));

        double salary = sut.getSalaryAfterDeductions(1);

    }

    public CreateEmployeeDTO buildEmployeeDto() {
        CreateEmployeeDTO createEmployeeDTO = new CreateEmployeeDTO();
        createEmployeeDTO.setFirstName("Oda");
        createEmployeeDTO.setLastName("Nobunaga");
        createEmployeeDTO.setEmployerId(1);
        return createEmployeeDTO;
    }
}
