package com.employee.deductions.db.repository;

import com.employee.deductions.db.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
    Employer findByEmployerName(String employerName);
}
