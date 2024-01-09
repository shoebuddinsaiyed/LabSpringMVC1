package com.greatLearning.gl.Service;

import java.util.List;

import com.greatLearning.gl.Entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees(); // get the list of employees

	Employee saveEmployee(Employee employee);// save the details of employee

	public Employee getEmployeeById(Long id);

	public Employee viewEmployee(Long id); // view the employee details

	public Employee updateEmployee(Employee employee); // update or edit the details of employee

	public void deleteEmployee(Long id); // delete the employee by id

}
