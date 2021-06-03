package com.employee.deductions.db.repository;

import com.employee.deductions.db.model.Dependant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependantRepository extends JpaRepository<Dependant, Integer> {
}
