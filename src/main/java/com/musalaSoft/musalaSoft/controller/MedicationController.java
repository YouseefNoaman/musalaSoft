package com.musalaSoft.musalaSoft.controller;

import com.musalaSoft.musalaSoft.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/medication")
public class MedicationController {

    MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping()
    ResponseEntity<?> getAllMedications(){
        return new ResponseEntity<>(medicationService.getAllMedications(), HttpStatus.OK);
    }

}
