package com.example.demo.controller;

import com.example.demo.model.EmploymentAgreement;
import com.example.demo.service.EmploymentAgreementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/api/employment-agreements")
@Tag(name = "Employment Agreements", description = "APIs for managing Employment Agreements")
public class EmploymentAgreementController {

    @Autowired
    private EmploymentAgreementService service;

    @PostMapping
    @Operation(summary = "Create a new Employment Agreement")
    public EmploymentAgreement createAgreement(@Valid @RequestBody EmploymentAgreement agreement) {
        return service.createAgreement(agreement);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing Employment Agreement")
    public ResponseEntity<EmploymentAgreement> updateAgreement(
            @PathVariable Long id, @Valid @RequestBody EmploymentAgreement agreement) {
        EmploymentAgreement updated = service.updateAgreement(id, agreement);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Partially update an Employment Agreement")
    public ResponseEntity<EmploymentAgreement> partialUpdateAgreement(
            @PathVariable Long id, @RequestBody EmploymentAgreement agreement) {
        EmploymentAgreement updated = service.partialUpdateAgreement(id, agreement);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Retrieve an Employment Agreement by ID")
    public ResponseEntity<EmploymentAgreement> getAgreement(@PathVariable Long id) {
        EmploymentAgreement agreement = service.getAgreement(id);
        return agreement != null ? ResponseEntity.ok(agreement) : ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "List all Employment Agreements")
    public List<EmploymentAgreement> listAgreements() {
        return service.listAgreements();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an Employment Agreement")
    public ResponseEntity<Void> deleteAgreement(@PathVariable Long id) {
        service.deleteAgreement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    @Operation(summary = "Search Employment Agreements by criteria")
    public List<EmploymentAgreement> searchAgreements(
            @RequestParam(required = false) String employeeName,
            @RequestParam(required = false) String department) {
        return service.searchAgreements(employeeName, department);
    }
}
