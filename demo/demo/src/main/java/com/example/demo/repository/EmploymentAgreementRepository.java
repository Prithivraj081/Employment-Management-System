package com.example.demo.repository;

import com.example.demo.model.EmploymentAgreement;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentAgreementRepository extends JpaRepository<EmploymentAgreement, Long> {
	List<EmploymentAgreement> findByEmployeeName(String employeeName);
	List<EmploymentAgreement> findByDepartment(String department);
	List<EmploymentAgreement> findByEmployeeNameAndDepartment(String employeeName, String department);

}
