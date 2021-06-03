package com.employee.deductions.dto;

public class EmployeeTableDTO {
    private int id;

    private String name;

    private Long salary;

    private int dependants;

    private Long netSalary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public int getDependants() {
        return dependants;
    }

    public void setDependants(int dependants) {
        this.dependants = dependants;
    }

    public Long getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Long netSalary) {
        this.netSalary = netSalary;
    }
}
