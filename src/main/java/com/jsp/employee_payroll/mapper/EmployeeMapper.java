package com.jsp.employee_payroll.mapper;

import com.jsp.employee_payroll.dto.employee.EmployeeRequestDto;
import com.jsp.employee_payroll.dto.employee.EmployeeResponse;
import com.jsp.employee_payroll.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeeMapper
{

    public Employee toEnitiy(EmployeeRequestDto employeeRequestDto, Employee employee)
    {
        employee.setEmployeeName(employeeRequestDto.name());
        employee.setDepartment(employeeRequestDto.department());
        employee.setEmail(employeeRequestDto.email());
        employee.setSalary(employeeRequestDto.salary());

        return employee;
    }

    public EmployeeRequestDto toData(Employee employee1)
    {
        if(employee1 == null)
            return null;

        return new EmployeeRequestDto(
                employee1.getEmployeeName(),
                employee1.getEmail(),
                employee1.getDepartment(),
                employee1.getSalary()
        );
    }

    public EmployeeResponse toResponse(Employee employee)
    {
        if(employee == null)
        {
            return null;
        }
        return new EmployeeResponse(
                employee.getEmployeeName(),
                employee.getDepartment(),
                employee.getEmail(),
                employee.getSalary()
        );
    }
}
