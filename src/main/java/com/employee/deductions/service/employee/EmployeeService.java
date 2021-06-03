package com.employee.deductions.service.employee;

import com.employee.deductions.db.model.Employee;
import com.employee.deductions.dto.CreateEmployeeDTO;
import com.employee.deductions.dto.EmployeeTableDTO;

import java.util.List;

public interface EmployeeService {
    void createEmployee(CreateEmployeeDTO employee);

    Employee getEmployeeById(int id);

    Long getSalaryAfterDeductions(int id);

    List<EmployeeTableDTO> getEmployeeTableData(int id);

    void deleteEmployee(Employee employee);
}
