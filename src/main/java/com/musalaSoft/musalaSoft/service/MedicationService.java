package com.musalaSoft.musalaSoft.service;

import com.musalaSoft.musalaSoft.entity.Medication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicationService {
    List<Medication> getAllMedications();
    Medication getMedicationById(Long id);
    Medication saveMedication(Medication medication);
    Medication updateMedication(Long id, Medication medication);
    Medication deleteMedication(Long id);
    Medication deleteMedication(Medication medication);
}
