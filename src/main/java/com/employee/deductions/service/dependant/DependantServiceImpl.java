package com.employee.deductions.service.dependant;

import com.employee.deductions.db.model.Dependant;
import com.employee.deductions.db.repository.DependantRepository;
import com.employee.deductions.db.repository.EmployeeRepository;
import com.employee.deductions.dto.CreateDependantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class DependantServiceImpl implements DependantService {
    @Autowired
    DependantRepository dependantRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Dependant createDependant(CreateDependantDTO dependant) {
        Dependant newDependant = new Dependant();
        newDependant.setFirstName(dependant.getFirstName());
        newDependant.setLastName(dependant.getLastName());
        newDependant.setEmployeeId(dependant.getEmployeeId());

        employeeRepository.findById(dependant.getEmployeeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Employee ID"));

        return dependantRepository.save(newDependant);
    }
}
