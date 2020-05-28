package com.mxplayer.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private String employeeID;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @Column(name = "name")
    private String name;

    @Column(name = "Designation")
    @JsonIgnore
    private String designation;

    @Column(name = "Department")
    @JsonIgnore
    private String department;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)//Avoiding empty json arrays.objects
    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    private List<Employee> reportees;

}