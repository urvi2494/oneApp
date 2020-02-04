package com.cognizant.gateway.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.gateway.model.Role;
import com.cognizant.gateway.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Query(name="select r from User u inner join Role r on u.role.roleId=r.roleId where u.userId=:userId")
	Role findByUserId(String userId);
	
}
