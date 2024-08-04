package com.indra.abes.service;

import java.util.List;

import com.indra.abes.entity.Employee;

public interface EmpService {

	public Employee saveEmp(Employee emp);
	
	public List<Employee> getAllEmp();
	
	public Employee getEmpbyId(int id);
	
	public boolean deleteEmp(int id); 
}
