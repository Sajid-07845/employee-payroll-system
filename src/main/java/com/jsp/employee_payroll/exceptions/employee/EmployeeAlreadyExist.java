package com.jsp.employee_payroll.exceptions.employee;

public class EmployeeAlreadyExist extends RuntimeException {
    public EmployeeAlreadyExist(String message) {
        super(message);
    }
}
