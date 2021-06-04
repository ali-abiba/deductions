package com.employee.deductions.service.dependant;

import com.employee.deductions.db.model.Dependant;
import com.employee.deductions.dto.CreateDependantDTO;

public interface DependantService {
    Dependant createDependant(CreateDependantDTO dependant);
}
