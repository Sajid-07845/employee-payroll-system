package com.jsp.employee_payroll.controller.leave;

import com.jsp.employee_payroll.dto.leave_request.LeaveRequest_Request;
import com.jsp.employee_payroll.dto.leave_request.LeaveRequest_Response;
import com.jsp.employee_payroll.service.LeaveRequestService;
import com.jsp.employee_payroll.utility.ResponseStructure;
import com.jsp.employee_payroll.utility.ResponseStructureBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LeaveRequestController
{
    private final LeaveRequestService leaveRequestService;
    private  final ResponseStructureBuilder responseStructureBuilder;

    @PostMapping("/employees/leaveRequest")
    public ResponseEntity<ResponseStructure<LeaveRequest_Request>> AddLeave(@RequestBody LeaveRequest_Request leaveRequestRequest)
    {
       LeaveRequest_Request request = leaveRequestService.addleave(leaveRequestRequest);
       return responseStructureBuilder.success(HttpStatus.OK,"Leave Added Sucessfully",request);
    }

    @GetMapping("/leaveRequests/{employeeId}")
    public ResponseEntity<ResponseStructure<LeaveRequest_Response>> GetLeaveByID (@PathVariable String employeeId)
    {
      LeaveRequest_Response leaveRequestResponse = leaveRequestService.getEmployeeById(employeeId);
      return responseStructureBuilder.success(HttpStatus.OK,"Founded Successfully",leaveRequestResponse);
    }
}
