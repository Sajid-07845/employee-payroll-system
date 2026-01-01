package com.jsp.employee_payroll.service;

import com.jsp.employee_payroll.dto.payroll.PayrollRequest;
import com.jsp.employee_payroll.dto.payroll.PayrollResponse;
import com.jsp.employee_payroll.enums.PayrollMonth;

import java.util.List;

public interface PayrollService {
    PayrollRequest addPayroll(PayrollRequest payrollRequest);

    List<PayrollResponse> getPayrollByMonth(PayrollMonth month);
}
