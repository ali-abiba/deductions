package com.employee.deductions.service.employer;

import com.employee.deductions.db.model.Employer;

public interface EmployerService {
    Employer createEmployer(String employerName);

    Employer getEmployerById(int id);
}
