package com.mxplayer.employee.service;

import com.mxplayer.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> getEmployee(String id);

    List<Employee> getEmployees();
}
