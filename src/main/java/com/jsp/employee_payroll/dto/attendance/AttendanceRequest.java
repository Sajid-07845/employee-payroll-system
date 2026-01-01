package com.jsp.employee_payroll.dto.attendance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record AttendanceRequest(

        @NotNull(message = "Date cannot be null")
        @PastOrPresent(message = "Date cannot be in the future")
        LocalDate date,

        @NotNull(message = "Present status is required")
        Boolean present,

        @NotBlank(message = "Employee ID is required")
        String employeeId
) {
}
