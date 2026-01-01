package com.jsp.employee_payroll.mapper;

import com.jsp.employee_payroll.dto.leave_request.LeaveRequest_Request;
import com.jsp.employee_payroll.dto.leave_request.LeaveRequest_Response;
import com.jsp.employee_payroll.entity.Employee;
import com.jsp.employee_payroll.entity.LeaveRequest;
import com.jsp.employee_payroll.enums.LeaveStatus;
import org.springframework.stereotype.Component;

@Component
public class LeaveRequestMapper
{

    public LeaveRequest toEntityCopy(Employee employee, LeaveRequest_Request leaveRequestRequest, LeaveRequest leaveRequest)
    {
        leaveRequest.setLeaveStatus(leaveRequestRequest.leaveStatus());
        leaveRequest.setFromDate(leaveRequestRequest.from_date());
        leaveRequest.setEndDate(leaveRequestRequest.enddate());
        leaveRequest.setEmployees(employee);

        return  leaveRequest;
    }


    public LeaveRequest_Request toDataRequest(LeaveRequest request)
    {
        if(request == null)
        {
            return null;
        }
        return new LeaveRequest_Request(
                request.getFromDate(),
                request.getEndDate(),
                request.getLeaveStatus(),
                request.getEmployees().getEmployeeId()
        );
    }

    public LeaveRequest_Response toResponse(LeaveRequest leaveRequest)
    {
        if (leaveRequest == null)
        {
            return null;
        }
        return new LeaveRequest_Response(
                leaveRequest.getFromDate(),
                leaveRequest.getEndDate(),
                leaveRequest.getLeaveStatus()
        );
    }
}
