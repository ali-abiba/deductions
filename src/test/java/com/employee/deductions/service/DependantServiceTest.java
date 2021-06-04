package com.employee.deductions.service;

import com.employee.deductions.db.model.Dependant;
import com.employee.deductions.db.model.Employee;
import com.employee.deductions.db.repository.DependantRepository;
import com.employee.deductions.db.repository.EmployeeRepository;
import com.employee.deductions.dto.CreateDependantDTO;
import com.employee.deductions.service.dependant.DependantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DependantServiceTest {
    @InjectMocks
    DependantServiceImpl sut;

    @Mock
    DependantRepository dependantRepository;

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    public void testCreateDependant() {
        CreateDependantDTO createDependantDTO = createDependantDTO();

        when(employeeRepository.findById(any())).thenReturn(Optional.of(new Employee()));

        Dependant dependant = sut.createDependant(createDependantDTO);
        verify(dependantRepository).save(any(Dependant.class));
    }

    @Test
    public void testCreateDependantInvalidEmployee() {
        Assertions.assertThrows(ResponseStatusException.class, () -> {
           sut.createDependant(createDependantDTO());
        });
    }

    private CreateDependantDTO createDependantDTO() {
        CreateDependantDTO createDependantDTO = new CreateDependantDTO();
        createDependantDTO.setEmployeeId(1);
        createDependantDTO.setFirstName("Oda");
        createDependantDTO.setLastName("Nobuhide");
        return createDependantDTO;
    }
}
