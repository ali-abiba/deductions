package com.employee.deductions.dto;

public class CreateEmployerDTO {
    private String employerName;

    public CreateEmployerDTO(String employerName) {
        this.employerName = employerName;
    }

    public CreateEmployerDTO(){
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
}
