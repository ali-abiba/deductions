package com.employee.deductions.db.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Long salary;

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Dependant> dependants;

    @Column(name = "employer_id")
    private int employerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public List<Dependant> getDependants() {
        return dependants;
    }

    public void setDependants(List<Dependant> dependants) {
        this.dependants = dependants;
    }

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }
}
