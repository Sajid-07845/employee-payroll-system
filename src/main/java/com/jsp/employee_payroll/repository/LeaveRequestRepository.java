package com.jsp.employee_payroll.repository;

import com.jsp.employee_payroll.entity.Employee;
import com.jsp.employee_payroll.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepository  extends JpaRepository<LeaveRequest,String>
{

    LeaveRequest findByEmployees_EmployeeId(String employeeId);
}
