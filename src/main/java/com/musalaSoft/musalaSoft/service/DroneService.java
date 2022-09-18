package com.musalaSoft.musalaSoft.service;

import com.musalaSoft.musalaSoft.entity.Drone;
import com.musalaSoft.musalaSoft.entity.Medication;

import java.util.List;

public interface DroneService {
    List<Drone> getAllDrones();
    Drone getDroneById(Long id);
    Drone saveDrone(Drone drone);
    Drone updateDrone(Long id, Drone drone);
    Drone deleteDrone(Long id);
    Drone deleteDrone(Drone drone);
    List<Medication> getMedicationsByDroneId(Long id);
    int getBatteryLevelByDroneId(Long id);
    List<Drone> getAvailableDronesToLoad();
    Drone addMedicationToDrone(Long id, Medication medication);
    Drone moveDroneToLoadingState(Long id);
}
