package com.jsp.employee_payroll.repository;

import com.jsp.employee_payroll.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,String>
{

//    Attendance findByEmployeeId(String employee);

    Attendance findByEmployee_EmployeeId(String employeeId);
}
