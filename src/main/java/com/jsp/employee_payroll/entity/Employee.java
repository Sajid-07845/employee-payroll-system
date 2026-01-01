package com.jsp.employee_payroll.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name = "Employee")
@Setter
@Getter
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "employee_name",nullable = false)
    private String employeeName;

    @Column(name = "employee_email",nullable = false,unique = true)
    private String email;

    @Column(name = "department",nullable = false)
    private String Department;

    @Column(name = "salary",nullable = false)
    private double salary;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "employees",fetch = FetchType.LAZY)
    private List<LeaveRequest> leaveRequests;

    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY)
    private List<Payroll> payrolls;
}
