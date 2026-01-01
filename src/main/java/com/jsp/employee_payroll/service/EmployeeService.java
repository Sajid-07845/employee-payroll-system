package com.jsp.employee_payroll.service;

import com.jsp.employee_payroll.dto.employee.EmployeeRequestDto;
import com.jsp.employee_payroll.dto.employee.EmployeeResponse;
import jakarta.validation.Valid;

public interface EmployeeService
{

    EmployeeRequestDto addEmployee(@Valid EmployeeRequestDto employeeRequestDto);

    EmployeeResponse getEmployeeEmail(String email);
}
