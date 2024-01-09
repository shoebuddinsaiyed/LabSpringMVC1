package com.greatLearning.gl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.gl.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
