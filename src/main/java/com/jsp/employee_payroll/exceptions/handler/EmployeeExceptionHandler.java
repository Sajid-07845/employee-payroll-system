package com.jsp.employee_payroll.exceptions.handler;

import com.jsp.employee_payroll.exceptions.employee.EmployeeAlreadyExist;
import com.jsp.employee_payroll.utility.ErrorStructure;
import com.jsp.employee_payroll.utility.ErrorStructureBuilder;
import com.jsp.employee_payroll.utility.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class EmployeeExceptionHandler
{
    private final ErrorStructureBuilder errorStructureBuilder;


    @ExceptionHandler(EmployeeAlreadyExist.class)
    public ResponseEntity<ErrorStructure<String>> handleEmployeeAlredyExist(EmployeeAlreadyExist ex)
    {
        return errorStructureBuilder.failure(HttpStatus.BAD_REQUEST,"User Already Exist",ex.getMessage());
    }
}
