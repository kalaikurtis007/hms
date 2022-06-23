package com.hms.dharani.persistence.entity;

import javax.persistence.*;
import java.util.Date;

//@Entity
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String employee;
    private String leaveReason;
    private Date startDate;
    private Date endDate;
    private int numberofDays;

    @ManyToOne
    private Employee approvedby;

    private boolean isActive;

}
