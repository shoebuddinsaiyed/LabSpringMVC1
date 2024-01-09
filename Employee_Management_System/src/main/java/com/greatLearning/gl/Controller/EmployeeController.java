package com.greatLearning.gl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatLearning.gl.Entity.Employee;
import com.greatLearning.gl.Service.EmployeeService;

@Controller

public class EmployeeController {
	// using service object for respective url's
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public String ListEmployees(Model model) {// define model object
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employee";

	}

	@GetMapping("employees/new")
	public String createemployeeForm(Model model) {
		Employee employees = new Employee();
		model.addAttribute("employees", employees);
		return "createEmployee";
	}

	@PostMapping("/employees")
	public String saveEmployee(Model model, @ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("employees/edit/{id}")
	public String editEmployee(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirst_Name(employee.getFirst_Name());
		existingEmployee.setLast_Name(employee.getLast_Name());
		existingEmployee.setEmail(employee.getEmail());
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/view")
	public String viewEmployeeForm(Model model) {
		List<Employee> allEmployees = employeeService.getAllEmployees();
		model.addAttribute("employees", allEmployees);
		return "view_all_Employees";
	}

	@PostMapping("/employees/view")
	public String viewEmployee(@ModelAttribute("employee") Employee employee, Model model) {
		// Handle the form submission if needed, but in this case, it seems unnecessary
		return "redirect:/employees/view";
	}

	// to delete the ticket created by respective id
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employees";
	}

}
