package com.jsp.employee_payroll.service.serviceimpl;

import com.jsp.employee_payroll.dto.attendance.AttendanceRequest;
import com.jsp.employee_payroll.entity.Attendance;
import com.jsp.employee_payroll.entity.Employee;
import com.jsp.employee_payroll.exceptions.attendance.Attendances;
import com.jsp.employee_payroll.exceptions.employee.EmployeeAlreadyExist;
import com.jsp.employee_payroll.mapper.AttendanceMapper;
import com.jsp.employee_payroll.repository.AttendanceRepository;
import com.jsp.employee_payroll.repository.EmployeeRepository;
import com.jsp.employee_payroll.service.AttendanceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttendanceServiceImpl implements AttendanceService
{
    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;
    private final AttendanceMapper attendanceMapper;

    @Override
    public AttendanceRequest addAttendance(AttendanceRequest attendanceRequest)
    {
           Employee employee = employeeRepository.findById(attendanceRequest.employeeId()).orElseThrow(()->new EmployeeAlreadyExist("Employee Not Found"));

           Attendance attendance=attendanceMapper.toEntityCopy(attendanceRequest,employee,new Attendance());

        attendanceRepository.save(attendance);

       return attendanceMapper.toDto(attendance);

    }

    @Override
    public AttendanceRequest GetEmployeeById(Employee employeeId)
    {
       Employee employee= employeeRepository.findById(employeeId.getEmployeeId()).orElseThrow(()-> new EmployeeAlreadyExist("No epmloyee Found With This Id"));

       Attendance attendance=attendanceRepository.findByEmployee_EmployeeId(employee.getEmployeeId());

        return attendanceMapper.toResponse(attendance);
    }
}
