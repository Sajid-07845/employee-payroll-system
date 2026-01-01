package com.jsp.employee_payroll.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ErrorStructure <t>
{
    private int statusCode;
    private String message;
    private t data;
}
