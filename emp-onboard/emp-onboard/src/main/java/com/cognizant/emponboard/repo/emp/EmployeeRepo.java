package com.cognizant.emponboard.repo.emp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.emponboard.model.Employee;



@Repository
public interface EmployeeRepo  extends JpaRepository<Employee,Long>{

}
