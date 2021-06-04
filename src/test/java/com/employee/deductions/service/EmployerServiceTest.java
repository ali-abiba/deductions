package com.employee.deductions.service;

import com.employee.deductions.db.model.Employer;
import com.employee.deductions.db.repository.EmployerRepository;
import com.employee.deductions.service.employer.EmployerService;
import com.employee.deductions.service.employer.EmployerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployerServiceTest {
    @InjectMocks
    EmployerServiceImpl sut;

    @Mock
    EmployerRepository employerRepository;

    @Test
    public void testCreateNewEmployer(){
        when(employerRepository.findByEmployerName(any())).thenReturn(null);
        sut.createEmployer("Date Clan");
        verify(employerRepository).save(any(Employer.class));
    }

    @Test
    public void testCreateExistingEmployer(){
        when(employerRepository.findByEmployerName(any())).thenReturn(new Employer());
        sut.createEmployer("Mogami Clan");
        verify(employerRepository, never()).save(any());
    }
}
