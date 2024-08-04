package com.indra.abes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.indra.abes.entity.Employee;
import com.indra.abes.service.EmpService;


import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String index(Model m)
	{
		List<Employee>list =empService.getAllEmp();
		m.addAttribute("empList",list);
		
		return "index";
	}
	@GetMapping("/loadEmpSave")
	public String loadEmpSave()
	{
		return "emp_save";
	}
	
	
	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable int id)
	{
		System.out.println(id);
		return "edit_emp";
	} 
	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee emp , HttpSession session)
	{
		//System.out.println(emp);
		
		Employee newEmp = empService.saveEmp(emp);
		
		if(newEmp != null)
		{
			//System.out.println("save message");
			session.setAttribute("msg", "Registered Sucessfully");
		}
		else
		{
			System.out.println("something wrong on server");
			//session.setAttribute("msg", "Some thing wrong on Server");
		}
		return "redirect:/loadEmpSave";
	}
	
	@GetMapping("/deleteEmp/{id}")
	public String loadEmpSave(@PathVariable int id, HttpSession session) {
		boolean f = empService.deleteEmp(id);
		if (f) {
			session.setAttribute("msg", "Delete sucessfully");
		} else {
			session.setAttribute("msg", "something wrong on server");
		}
		return "redirect:/";
	}
	
}
