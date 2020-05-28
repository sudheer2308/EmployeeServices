package com.mxplayer.employee.service.impl;

import com.mxplayer.employee.model.Employee;
import com.mxplayer.employee.repository.EmployeeRepository;
import com.mxplayer.employee.service.EmployeeService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> getEmployee(String id) {
        if (StringUtils.isBlank(id)) {
            throw new IllegalArgumentException("Id cannot be Blank");
        }
       return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
