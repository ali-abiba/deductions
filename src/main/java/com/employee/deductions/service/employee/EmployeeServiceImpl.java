package com.employee.deductions.service.employee;

import com.employee.deductions.db.model.Dependant;
import com.employee.deductions.db.model.Employee;
import com.employee.deductions.db.model.Employer;
import com.employee.deductions.db.repository.EmployeeRepository;
import com.employee.deductions.db.repository.EmployerRepository;
import com.employee.deductions.dto.CreateEmployeeDTO;
import com.employee.deductions.dto.EmployeeTableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Long SALARY = 4000L;
    private final Long EMPLOYEE_DEDUCTION = 1000L;
    private final Long DEPENDANT_DEDUCTION = 500L;
    private final char DISCOUNT_ID = 'A';
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployerRepository employerRepository;

    public void createEmployee(CreateEmployeeDTO employee) {
        Employee newEmployee = new Employee();
        employerRepository.findById(employee.getEmployerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid EmployerID"));

        newEmployee.setId(employee.getId());
        newEmployee.setEmployerId(employee.getEmployerId());
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setSalary(employee.getSalary() != null && employee.getSalary() > 0 ? employee.getSalary() : SALARY);

        employeeRepository.save(newEmployee);
    }


    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No employee with id" + id));
    }

    public Long getSalaryAfterDeductions(int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No employee with id" + id));

        Long salary = determineNetPay(employee);

        return salary;
    }

    @Override
    public List<EmployeeTableDTO> getEmployeeTableData(int id) {
        List<Employee> employees = employerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No employer with id" + id)).getEmployees();

        List<EmployeeTableDTO> employeeTables = employees.stream().map(val -> {
           EmployeeTableDTO dto = new EmployeeTableDTO();
            dto.setId(val.getId());
            dto.setName(val.getFirstName() + " " + val.getLastName());
            dto.setDependants(val.getDependants().size());
            dto.setSalary(val.getSalary());
            dto.setNetSalary(determineNetPay(val));
            return dto;
        }).collect(Collectors.toList());

        return employeeTables;
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    private long determineNetPay(Employee employee) {
        Long salary = employee.getSalary() - determineDeductions(employee);

        return salary;
    }

    private long determineDeductions(Employee employee) {
        Long deduction = EMPLOYEE_DEDUCTION * determineDiscount(employee.getFirstName().toUpperCase());

        for(Dependant dependant: employee.getDependants()) {
            deduction += (DEPENDANT_DEDUCTION * determineDiscount(dependant.getFirstName().toUpperCase()));
        }

        return deduction;
    }

    private long determineDiscount(String name) {
        if(name.charAt(0) == DISCOUNT_ID) {
            return (long).9;
        } else {
            return 1;
        }
    }
}
