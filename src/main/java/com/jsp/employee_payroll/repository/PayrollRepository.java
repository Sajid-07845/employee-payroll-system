package com.jsp.employee_payroll.repository;

import com.jsp.employee_payroll.entity.Payroll;
import com.jsp.employee_payroll.enums.PayrollMonth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayrollRepository  extends JpaRepository<Payroll,String>
{

    List<Payroll> findByPayrollMonth(PayrollMonth payrollMonth);
}
