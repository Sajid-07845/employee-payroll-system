package com.jsp.employee_payroll.mapper;

import com.jsp.employee_payroll.dto.attendance.AttendanceRequest;
import com.jsp.employee_payroll.entity.Attendance;
import com.jsp.employee_payroll.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper
{

    public Attendance toEntityCopy(AttendanceRequest attendanceRequest, Employee employee, Attendance attendance)
    {
        attendance.setDate(attendanceRequest.date());
        attendance.setPresent(attendanceRequest.present());
        attendance.setEmployee(employee);
        return attendance;
    }

    public AttendanceRequest toDto(Attendance attendance)
    {
        if(attendance == null)
        {
            return null;
        }
        return new AttendanceRequest(
                attendance.getDate(),
                attendance.isPresent(),
                attendance.getEmployee().getEmployeeId()
        );

    }

    public AttendanceRequest toResponse(Attendance attendance)
    {
        if(attendance == null)
        {
            return  null;
        }
        return new AttendanceRequest(
                attendance.getDate(),
                attendance.isPresent(),
                attendance.getEmployee().getEmployeeId()
        );
    }
}
