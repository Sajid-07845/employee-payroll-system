package com.jsp.employee_payroll.utility;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseStructure<t>
{
    private int statusCode;
    private String message;
    private t data;


}
