package com.jsp.employee_payroll.entity;

import com.jsp.employee_payroll.enums.LeaveStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "LeaveRequest")
@Setter
@Getter
public class LeaveRequest
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "leave_id",nullable = false,unique = true)
    private String Id;

    @Column(name = "from_date",nullable = false)
    private LocalDate fromDate;

    @Column(name = "end_date",nullable = false)
    private LocalDate EndDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "leave_status",nullable = false)
    private LeaveStatus leaveStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employees;



}
