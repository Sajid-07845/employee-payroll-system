package com.jsp.employee_payroll.exceptions.handler;

import com.jsp.employee_payroll.exceptions.payroll.PayrollException;
import com.jsp.employee_payroll.utility.ErrorStructure;
import com.jsp.employee_payroll.utility.ErrorStructureBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class PayrollExceptionHandler {

    private final ErrorStructureBuilder errorStructureBuilder;

    @ExceptionHandler(PayrollException.class)
    public ResponseEntity<ErrorStructure<String>> handlePayrollException(PayrollException ex)
    {
        return errorStructureBuilder.failure(HttpStatus.NOT_FOUND,"Not Present In Db",ex.getMessage());
    }
}
