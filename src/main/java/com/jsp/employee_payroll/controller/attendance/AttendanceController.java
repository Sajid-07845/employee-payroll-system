package com.jsp.employee_payroll.controller.attendance;

import com.jsp.employee_payroll.dto.attendance.AttendanceRequest;
import com.jsp.employee_payroll.dto.attendance.AttendenceResponse;
import com.jsp.employee_payroll.entity.Employee;
import com.jsp.employee_payroll.service.AttendanceService;
import com.jsp.employee_payroll.utility.ResponseStructure;
import com.jsp.employee_payroll.utility.ResponseStructureBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AttendanceController
{
    private final AttendanceService attendanceService;
    private final ResponseStructureBuilder responseStructureBuilder;


    @PostMapping("/employees/attendances")
    public ResponseEntity<ResponseStructure<AttendanceRequest>> addAttendance (@Valid @RequestBody AttendanceRequest attendanceRequest)
    {
        AttendanceRequest request = attendanceService.addAttendance(attendanceRequest);
        return responseStructureBuilder.success(HttpStatus.OK,"Added",request);
    }

    @GetMapping("/attendances/{employeeId}")
    public ResponseEntity<ResponseStructure<AttendanceRequest>> GetAttendanceByEmployeeId(@PathVariable Employee employeeId)
    {
       AttendanceRequest request = attendanceService.GetEmployeeById(employeeId);
       return responseStructureBuilder.success(HttpStatus.OK,"Founded Sucessfully",request);
    }
}
