package com.jsp.employee_payroll.dto.employee;

import jakarta.validation.constraints.*;

public record EmployeeRequestDto(
    @Size(min = 3,max =25,message = "name filed cannot be null")
    @NotBlank(message = "Cannot be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only alphabets")
    String name,

    @Email
    @Size(min=6,max = 15,message = "cannot be null")
    @NotBlank
    String email,

    @Size(min=3,max = 15,message = "cannot be null")
    @NotBlank
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Department must contain only alphabets")
    String department,

    @Positive(message = "salary must be in positive")
    double salary

) {
}
