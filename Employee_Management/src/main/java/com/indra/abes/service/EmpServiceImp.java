package com.indra.abes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.indra.abes.dao.EmpRepository;
import com.indra.abes.entity.Employee;

import jakarta.servlet.http.HttpSession;


@Service
public class EmpServiceImp implements EmpService {

	@Autowired
	private EmpRepository empRepo;
	
	@Override
	public Employee saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		
		Employee newEmp = empRepo.save(emp);
		
		return newEmp;
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpbyId(int id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		// TODO Auto-generated method stub
		
		Employee emp = empRepo.findById(id).get();
		if(emp != null)
		{
			empRepo.delete(emp);
			
			return true;
		}
		
		return false;
	}
	
	public void removeSessionMessage()
	{
		HttpSession session =  ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes()))
				.getRequest().getSession();
		
		session.removeAttribute("msg");
	}

}
