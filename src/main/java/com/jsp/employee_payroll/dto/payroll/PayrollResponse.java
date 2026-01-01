package com.jsp.employee_payroll.dto.payroll;

import com.jsp.employee_payroll.dto.employee.EmployeeResponse;
import com.jsp.employee_payroll.entity.Employee;
import com.jsp.employee_payroll.enums.PayrollMonth;

public record PayrollResponse(
        PayrollMonth payrollMonth,
        double salary,
        long workingDays,
        long absent,
        EmployeeResponse employeeId
) {
}
