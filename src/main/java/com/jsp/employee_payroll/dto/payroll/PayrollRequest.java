package com.jsp.employee_payroll.dto.payroll;

import com.jsp.employee_payroll.enums.PayrollMonth;

import java.time.LocalDate;

public record PayrollRequest(
        PayrollMonth payrollMonth,
        double salary,
        long workingDays,
        long absent,
        String employeeId

) {
}
