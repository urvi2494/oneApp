package com.cognizant.gateway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.gateway.model.Role;
import com.cognizant.gateway.model.User;


public interface RolesRepository extends JpaRepository<Role, Integer> {
	/*
	 * @Query(name="select r.roleName from Role r where r.user.userId=:username")
	 * List<String> findRolesByUserName(@Param("username") String username);
	 */

	/* List<Role> findByUser( User user); */
	
}
