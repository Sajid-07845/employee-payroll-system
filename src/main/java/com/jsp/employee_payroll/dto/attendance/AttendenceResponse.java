package com.jsp.employee_payroll.dto.attendance;

import org.springframework.cglib.core.Local;

public record AttendenceResponse(
        Local date,
        boolean present,
        String employeeId

) {
}
