package com.musalaSoft.musalaSoft.service;

import com.musalaSoft.musalaSoft.entity.Medication;

import java.util.List;

public interface MedicationService {
    List<Medication> getAllMedications();
    Medication getMedicationById(Long id);
    Medication saveMedication(Medication medication);
    Medication updateMedication(Long id, Medication medication);
    Medication deleteMedication(Long id);
    Medication deleteMedication(Medication medication);
}
