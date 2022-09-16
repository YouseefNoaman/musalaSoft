package com.musalaSoft.musalaSoft.service.serviceIMPL;

import com.musalaSoft.musalaSoft.entity.Medication;
import com.musalaSoft.musalaSoft.helper.Util;
import com.musalaSoft.musalaSoft.repository.MedicationRepository;
import com.musalaSoft.musalaSoft.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class MedicationServiceIMPL implements MedicationService {

    Util util;
    MedicationRepository medicationRepository;

    @Autowired
    public MedicationServiceIMPL(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    @Override
    public Medication getMedicationById(Long id) {
        Optional<Medication> temp = medicationRepository.findById(id);
        return temp.orElse(null);
    }

    @Override
    public Medication saveMedication(Medication medication) {
        if (util.checkMedicationCode(medication.getCode()) && util.checkMedicationName(medication.getName())){
            return medicationRepository.save(medication);
        }
        return null;
    }

    @Override
    public Medication updateMedication(Long id, Medication medication) {
        Medication temp = getMedicationById(id);
        if (util.checkMedicationCode(medication.getCode()) && util.checkMedicationName(medication.getName())) {
            if (Objects.nonNull(temp)) {
                medication.setId(temp.getId());
                medicationRepository.save(medication);
            }
            return medication;
        }
        return null;
    }

    @Override
    public Medication deleteMedication(Long id) {
        Medication temp = getMedicationById(id);
        if(Objects.nonNull(temp)){
            medicationRepository.deleteById(id);
        }
        return temp;
    }

    @Override
    public Medication deleteMedication(Medication medication){
        medicationRepository.delete(medication);
        return medication;
    }

}
