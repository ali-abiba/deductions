package com.employee.deductions.service.employer;

import com.employee.deductions.db.model.Employer;
import com.employee.deductions.db.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    EmployerRepository employerRepo;

    public Employer createEmployer(String employerName) {
        Employer employer = employerRepo.findByEmployerName(employerName);

        if(employer == null) {
            employer = new Employer();
            employer.setEmployerName(employerName);
            employer = employerRepo.save(employer);
        }
        return employer;
    }

    public Employer getEmployerById(int id) {
        return employerRepo.findById(id).orElse(null);
    }
}
