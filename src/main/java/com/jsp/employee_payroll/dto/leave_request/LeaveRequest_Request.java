package com.jsp.employee_payroll.dto.leave_request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jsp.employee_payroll.enums.LeaveStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LeaveRequest_Request(
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate enddate,
        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate from_date,

        @NotNull
        LeaveStatus leaveStatus,

        @NotNull
        String employee_id
) {
}
