package com.jsp.employee_payroll.dto.employee;

public record EmployeeResponse(
        String name,
        String department,
        String email,
        double salary
) {
}
