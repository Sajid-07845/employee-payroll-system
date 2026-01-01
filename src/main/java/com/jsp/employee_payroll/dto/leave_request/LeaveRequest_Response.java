package com.jsp.employee_payroll.dto.leave_request;

import com.jsp.employee_payroll.enums.LeaveStatus;

import java.time.LocalDate;

public record LeaveRequest_Response(
        LocalDate from,
        LocalDate end,
        LeaveStatus leaveStatus
) {
}
