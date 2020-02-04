package com.cognizant.emponboard.repo.vc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.emponboard.model.VerifiableCredential;




@Repository
public interface VerifiableCredentialRepo extends JpaRepository<VerifiableCredential, Long> {

	@Query("select vc from VerifiableCredential vc where vc.employeeId= :empId")
	public VerifiableCredential findVCByEmpID(@Param("empId") Long empId);
}
