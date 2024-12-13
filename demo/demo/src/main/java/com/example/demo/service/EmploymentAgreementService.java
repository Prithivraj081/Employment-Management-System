package com.example.demo.service;

import com.example.demo.model.EmploymentAgreement;
import com.example.demo.repository.EmploymentAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmploymentAgreementService {

    private static final Logger logger = LoggerFactory.getLogger(EmploymentAgreementService.class);

    @Autowired
    private EmploymentAgreementRepository repository;

    public EmploymentAgreement createAgreement(EmploymentAgreement agreement) {
        logger.info("Creating new employment agreement for {}", agreement.getEmployeeName());
        return repository.save(agreement);
    }

    public EmploymentAgreement getAgreement(Long id) {
        logger.info("Fetching employment agreement with ID {}", id);
        return repository.findById(id).orElse(null);
    }

    public List<EmploymentAgreement> listAgreements() {
        logger.info("Listing all employment agreements");
        return repository.findAll();
    }

    public EmploymentAgreement updateAgreement(Long id, EmploymentAgreement agreement) {
        logger.info("Updating employment agreement with ID {}", id);
        return repository.findById(id).map(existing -> {
            existing.setEmployeeName(agreement.getEmployeeName());
            existing.setDepartment(agreement.getDepartment());
            existing.setRole(agreement.getRole());
            existing.setSalary(agreement.getSalary());
            existing.setStartDate(agreement.getStartDate());
            existing.setEndDate(agreement.getEndDate());
            existing.setTerms(agreement.getTerms());
            existing.setManager(agreement.getManager());
            return repository.save(existing);
        }).orElse(null);
    }

    public void deleteAgreement(Long id) {
        logger.info("Deleting employment agreement with ID {}", id);
        repository.deleteById(id);
    }

    public List<EmploymentAgreement> searchAgreements(String employeeName, String department) {
        logger.info("Searching agreements by employeeName={} and department={}", employeeName, department);
        if (employeeName != null && department != null) {
            return repository.findByEmployeeNameAndDepartment(employeeName, department);
        } else if (employeeName != null) {
            return repository.findByEmployeeName(employeeName);
        } else if (department != null) {
            return repository.findByDepartment(department);
        }
        return repository.findAll();
    }

    public EmploymentAgreement partialUpdateAgreement(Long id, EmploymentAgreement updatedFields) {
        logger.info("Partially updating employment agreement with ID {}", id);
        EmploymentAgreement existingAgreement = repository.findById(id).orElse(null);
        if (existingAgreement == null) {
            return null;
        }

        if (updatedFields.getEmployeeName() != null) {
            existingAgreement.setEmployeeName(updatedFields.getEmployeeName());
        }
        if (updatedFields.getDepartment() != null) {
            existingAgreement.setDepartment(updatedFields.getDepartment());
        }
        if (updatedFields.getRole() != null) {
            existingAgreement.setRole(updatedFields.getRole());
        }
        if (updatedFields.getSalary() != null && updatedFields.getSalary() > 0) {
            existingAgreement.setSalary(updatedFields.getSalary());
        }
        if (updatedFields.getStartDate() != null) {
            existingAgreement.setStartDate(updatedFields.getStartDate());
        }
        if (updatedFields.getEndDate() != null) {
            existingAgreement.setEndDate(updatedFields.getEndDate());
        }
        if (updatedFields.getManager() != null) {
            existingAgreement.setManager(updatedFields.getManager());
        }
        if (updatedFields.getTerms() != null) {
            existingAgreement.setTerms(updatedFields.getTerms());
        }

        return repository.save(existingAgreement);
    }
}
