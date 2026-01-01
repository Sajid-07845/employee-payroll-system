package com.jsp.employee_payroll.controller.employee;

import com.jsp.employee_payroll.dto.employee.EmployeeRequestDto;
import com.jsp.employee_payroll.dto.employee.EmployeeResponse;
import com.jsp.employee_payroll.service.EmployeeService;
import com.jsp.employee_payroll.utility.ResponseStructure;
import com.jsp.employee_payroll.utility.ResponseStructureBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmployeeController
{
    private EmployeeService employeeService;
    private ResponseStructureBuilder responseStructureBuilder;

    @PostMapping("/employees")
    public ResponseEntity<ResponseStructure<EmployeeRequestDto>> addEmployee (@Valid @RequestBody EmployeeRequestDto employeeRequestDto)
    {
        EmployeeRequestDto employeeRequestDto1 =employeeService.addEmployee(employeeRequestDto);
        return responseStructureBuilder.success(HttpStatus.OK,"Employee Added",employeeRequestDto1);
    }

    @GetMapping("/employees/{email}")
    public ResponseEntity<ResponseStructure<EmployeeResponse>> getEmployeeEmail(@PathVariable String email)
    {
        EmployeeResponse employeeEmail=employeeService.getEmployeeEmail(email);
        return responseStructureBuilder.success(HttpStatus.OK,"Employee Fetched Successfully",employeeEmail);
    }
}
