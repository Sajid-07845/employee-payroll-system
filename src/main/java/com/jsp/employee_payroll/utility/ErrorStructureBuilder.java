package com.jsp.employee_payroll.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ErrorStructureBuilder
{
   public ResponseEntity<ErrorStructure<String>> failure (HttpStatus status,String message,String data)
    {
        ErrorStructure<String> stringErrorStructure = ErrorStructure
                .<String>builder()
                .statusCode(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status)
                .body(stringErrorStructure);

    }
}
