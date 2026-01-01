package com.jsp.employee_payroll.mapper;

import com.jsp.employee_payroll.dto.employee.EmployeeResponse;
import com.jsp.employee_payroll.dto.payroll.PayrollRequest;
import com.jsp.employee_payroll.dto.payroll.PayrollResponse;
import com.jsp.employee_payroll.entity.Employee;
import com.jsp.employee_payroll.entity.Payroll;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PayrollMapper
{

    public Payroll toEntity(PayrollRequest payrollRequest, Payroll payroll, Employee employee)
    {
        payroll.setAbsent(payrollRequest.absent());
        payroll.setSalary(payrollRequest.salary());
        payroll.setPayrollMonth(payrollRequest.payrollMonth());
        payroll.setWorkingDays(payrollRequest.workingDays());
        payroll.setEmployee(employee);
        return payroll;

    }

    public PayrollRequest toRequest(Payroll payroll)
    {
        if (payroll == null)
        {
            return null;
        }
        return new PayrollRequest(
                payroll.getPayrollMonth(),
                payroll.getSalary(),
                payroll.getAbsent(),
                payroll.getWorkingDays(),
                payroll.getEmployee().getEmployeeId()
        );
    }

    public List<PayrollResponse> toResponseList(List<Payroll> payrolls)
    {
        List<PayrollResponse> l = new ArrayList<>();
        for(Payroll p :payrolls)
        {
                    l.add(toResponse(p));
        }

        return l;

    }

    private PayrollResponse toResponse(Payroll p)
    {
        if (p == null || p.getEmployee() == null)
        {
            return null;
        }

        Employee e = p.getEmployee();

        EmployeeResponse employeeResponse = new EmployeeResponse(
                e.getEmployeeName(),
                e.getDepartment(),
                e.getEmail(),
                e.getSalary()
        );

        return new PayrollResponse(
                p.getPayrollMonth(),
                p.getSalary(),
                p.getAbsent(),
                p.getWorkingDays(),
                employeeResponse
        );
    }
}
