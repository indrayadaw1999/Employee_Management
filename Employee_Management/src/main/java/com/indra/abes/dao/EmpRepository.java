package com.indra.abes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.abes.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee,Integer> {

}
   