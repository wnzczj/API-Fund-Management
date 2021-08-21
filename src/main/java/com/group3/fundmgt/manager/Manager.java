package com.group3.fundmgt.manager;


import com.group3.fundmgt.fund.Fund;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Fund> funds;

    public Manager() { }

    public Manager(Long employeeId, String firstName, String lastName, List<Fund> funds) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.funds = funds;
    }

    public Manager(String firstName, String lastName, List<Fund> funds) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.funds = funds;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public List<Fund> getFunds() {
        return funds;
    }

    public void setFunds(List<Fund> funds) {
        this.funds = funds;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", funds=" + funds +
                '}';
    }
}
