package com.jsp.employee_payroll.entity;

import com.jsp.employee_payroll.enums.PayrollMonth;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Payroll")
@Setter
@Getter
public class Payroll
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payroll_id",nullable = false,unique = true)
    private String id;

    @Column(name = "month",nullable = false)
    @Enumerated(EnumType.STRING)
    private PayrollMonth payrollMonth;

    @Column(name = "salary",nullable = false)
    private double salary;

    @Column(name = "working_days",nullable = false)
    private long workingDays;

    @Column(name = "absent",nullable = false)
    private long absent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;


}
