package com.jsp.employee_payroll.service.serviceimpl;

import com.jsp.employee_payroll.dto.leave_request.LeaveRequest_Request;
import com.jsp.employee_payroll.dto.leave_request.LeaveRequest_Response;
import com.jsp.employee_payroll.entity.Employee;
import com.jsp.employee_payroll.entity.LeaveRequest;
import com.jsp.employee_payroll.exceptions.employee.EmployeeAlreadyExist;
import com.jsp.employee_payroll.mapper.LeaveRequestMapper;
import com.jsp.employee_payroll.repository.EmployeeRepository;
import com.jsp.employee_payroll.repository.LeaveRequestRepository;
import com.jsp.employee_payroll.service.LeaveRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LeaveRequestServiceImpl implements LeaveRequestService
{
    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;
    private final LeaveRequestMapper leaveRequestMapper;

    @Override
    public LeaveRequest_Request addleave(LeaveRequest_Request leaveRequestRequest)
    {
       Employee employee = employeeRepository.findById(leaveRequestRequest.employee_id()).orElseThrow(()->new EmployeeAlreadyExist("No Employee Found"));

       if(leaveRequestRequest.from_date().isAfter(leaveRequestRequest.enddate()))
       {
           throw  new RuntimeException("Start Date Cannot be After end date");
       }
           LeaveRequest request = leaveRequestMapper.toEntityCopy(employee,leaveRequestRequest,new LeaveRequest());

            leaveRequestRepository.save(request);

           return leaveRequestMapper.toDataRequest(request);

    }

    @Override
    public LeaveRequest_Response getEmployeeById(String employeeId)
    {
       Employee employee = employeeRepository.findById(employeeId).orElseThrow(()-> new EmployeeAlreadyExist("No Employee Found"));
        LeaveRequest leaveRequest = leaveRequestRepository.findByEmployees_EmployeeId(employee.getEmployeeId());

        return leaveRequestMapper.toResponse(leaveRequest);
    }
}
