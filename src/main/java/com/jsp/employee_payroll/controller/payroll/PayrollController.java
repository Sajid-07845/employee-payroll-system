package com.jsp.employee_payroll.controller.payroll;

import com.jsp.employee_payroll.dto.payroll.PayrollRequest;
import com.jsp.employee_payroll.dto.payroll.PayrollResponse;
import com.jsp.employee_payroll.enums.PayrollMonth;
import com.jsp.employee_payroll.service.PayrollService;
import com.jsp.employee_payroll.utility.ResponseStructure;
import com.jsp.employee_payroll.utility.ResponseStructureBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@AllArgsConstructor
public class PayrollController
{
    private final PayrollService payrollService;
    private final ResponseStructureBuilder responseStructureBuilder;

    @PostMapping("/api/payrolls")
    public ResponseEntity<ResponseStructure<PayrollRequest>> addPayroll(@RequestBody PayrollRequest payrollRequest)
    {
       PayrollRequest request = payrollService.addPayroll(payrollRequest);
      return responseStructureBuilder.success(HttpStatus.OK,"Added Successfully",request);
    }

    @GetMapping("/api/payrolls/{month}")
    public ResponseEntity<ResponseStructure<List<PayrollResponse>>> getPayrollBYMonth(@PathVariable PayrollMonth month)
    {
       List<PayrollResponse> payroll= payrollService.getPayrollByMonth(month);
       return  responseStructureBuilder.success(HttpStatus.FOUND,"Fetched Successfully",payroll);
    }

    @GetMapping("/api/payrolls/employees/{employeeId}")
    public ResponseEntity<ResponseStructure<List<PayrollResponse>>> getPayrollByEmployeeId(@PathVariable String employeeId)
    {
        List<PayrollResponse> payroll= payrollService.getPayrollByEmployeeId(employeeId);
        return responseStructureBuilder.success(HttpStatus.OK,"Found Successfully",payroll);
    }

}
