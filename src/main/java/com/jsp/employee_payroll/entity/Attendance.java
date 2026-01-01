package com.jsp.employee_payroll.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Instantiator;

import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@Setter
@Getter
public class Attendance
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "attendance_id",nullable = false,unique = true)
    private String attendanceId;

    @Column(name = "date",nullable = false)
    private LocalDate date;

    @Column(name = "present",nullable = false)
    private boolean present;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

}
