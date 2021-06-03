package com.employee.deductions.db.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employer")
public class Employer implements Serializable {
    public Employer(String employerName) {
        this.employerName = employerName;
    }

    public Employer(int id, String employerName, List<Employee> employees) {
        this.id = id;
        this.employerName = employerName;
        this.employees = employees;
    }

    public Employer() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(unique = true)
    private String employerName;

    @OneToMany(mappedBy = "employerId")
    private List<Employee> employees;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
