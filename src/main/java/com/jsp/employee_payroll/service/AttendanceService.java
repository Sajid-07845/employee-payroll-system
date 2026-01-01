package com.jsp.employee_payroll.service;

import com.jsp.employee_payroll.dto.attendance.AttendanceRequest;
import com.jsp.employee_payroll.entity.Employee;
import jakarta.validation.Valid;

public interface AttendanceService {
    AttendanceRequest addAttendance(@Valid AttendanceRequest attendanceRequest);

    AttendanceRequest GetEmployeeById(Employee employeeId);
}
