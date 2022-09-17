package com.musalaSoft.musalaSoft.repository;

import com.musalaSoft.musalaSoft.entity.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {
}
