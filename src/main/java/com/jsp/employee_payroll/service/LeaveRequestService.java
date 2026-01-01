package com.jsp.employee_payroll.service;

import com.jsp.employee_payroll.dto.leave_request.LeaveRequest_Request;
import com.jsp.employee_payroll.dto.leave_request.LeaveRequest_Response;

public interface LeaveRequestService {
    LeaveRequest_Request addleave(LeaveRequest_Request leaveRequestRequest);

    LeaveRequest_Response getEmployeeById(String employeeId);
}
