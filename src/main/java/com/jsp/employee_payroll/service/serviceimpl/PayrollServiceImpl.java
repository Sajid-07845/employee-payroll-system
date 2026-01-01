package com.jsp.employee_payroll.service.serviceimpl;

import com.jsp.employee_payroll.dto.payroll.PayrollRequest;
import com.jsp.employee_payroll.dto.payroll.PayrollResponse;
import com.jsp.employee_payroll.entity.Employee;
import com.jsp.employee_payroll.entity.Payroll;
import com.jsp.employee_payroll.enums.PayrollMonth;
import com.jsp.employee_payroll.exceptions.employee.EmployeeAlreadyExist;
import com.jsp.employee_payroll.exceptions.payroll.PayrollException;
import com.jsp.employee_payroll.mapper.PayrollMapper;
import com.jsp.employee_payroll.repository.EmployeeRepository;
import com.jsp.employee_payroll.repository.PayrollRepository;
import com.jsp.employee_payroll.service.PayrollService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PayrollServiceImpl implements PayrollService
{
    private final PayrollRepository payrollRepository;
    private final PayrollMapper payrollMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public PayrollRequest addPayroll(PayrollRequest payrollRequest)
    {
       Employee employee = employeeRepository.findById(payrollRequest.employeeId()).orElseThrow(()-> new EmployeeAlreadyExist("NO Employee Found"));
       Payroll payroll= payrollMapper.toEntity(payrollRequest,new Payroll(),employee);
        payrollRepository.save(payroll);
      return  payrollMapper.toRequest(payroll);
    }

    @Override
    public List<PayrollResponse> getPayrollByMonth(PayrollMonth month)
    {
       List<Payroll> payrolls =  payrollRepository.findByPayrollMonth(month);

       if(payrolls.isEmpty())
       {
           throw new PayrollException("No Data Present");
       }
     return  payrollMapper.toResponseList(payrolls);


    }
}
