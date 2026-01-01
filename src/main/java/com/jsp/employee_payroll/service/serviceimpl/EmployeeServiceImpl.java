package com.jsp.employee_payroll.service.serviceimpl;

import com.jsp.employee_payroll.dto.employee.EmployeeRequestDto;
import com.jsp.employee_payroll.dto.employee.EmployeeResponse;
import com.jsp.employee_payroll.entity.Employee;
import com.jsp.employee_payroll.exceptions.employee.EmployeeAlreadyExist;
import com.jsp.employee_payroll.mapper.EmployeeMapper;
import com.jsp.employee_payroll.repository.EmployeeRepository;
import com.jsp.employee_payroll.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService
{
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @Override
    public EmployeeRequestDto addEmployee(EmployeeRequestDto employeeRequestDto)
    {
        String email=employeeRequestDto.email();
        Optional<Employee> employee= employeeRepository.findByEmail(email);

            if(employee.isPresent())
            {
                throw new EmployeeAlreadyExist("Employee Already Exist");
            }
               Employee employee1 =employeeMapper.toEnitiy(employeeRequestDto,new Employee());
                employeeRepository.save(employee1);

                EmployeeRequestDto employeeRequestDto1= employeeMapper.toData(employee1);

        return employeeRequestDto1;
    }

    @Override
    public EmployeeResponse getEmployeeEmail(String email)
    {
       Employee employee= employeeRepository.findByEmail(email).orElseThrow(
                ()-> new EmployeeAlreadyExist("No email Found With This email"));

       EmployeeResponse  employeeResponse= employeeMapper.toResponse(employee);
        return employeeResponse;
    }
}
