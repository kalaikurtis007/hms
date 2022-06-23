package com.hms.dharani.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String empId;
    private String firstName;
    private String lastName;

    @ManyToOne
    private Department departmentCode;
    private String designation;
    private boolean isActive;
    private String username;
    private String emailId;
    private String gender;
    private String martialStatus;
    private int employeeAge;
    private String employeeMobile;
    private Date dob;
    private Date doj;
    @ManyToOne
    private Branch branch;


}
