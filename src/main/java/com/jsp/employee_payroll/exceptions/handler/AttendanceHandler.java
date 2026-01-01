package com.jsp.employee_payroll.exceptions.handler;

import com.jsp.employee_payroll.exceptions.attendance.Attendances;
import com.jsp.employee_payroll.utility.ErrorStructure;
import com.jsp.employee_payroll.utility.ErrorStructureBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class AttendanceHandler
{
    private final ErrorStructureBuilder errorStructureBuilder;

    @ExceptionHandler(Attendances.class)
    public ResponseEntity<ErrorStructure<String>> handleAttendanceException(Attendances ex)
    {
        return errorStructureBuilder.failure(HttpStatus.BAD_REQUEST,"User Already Exist",ex.getMessage());
    }
}
