package com.musalaSoft.musalaSoft.service;

import com.musalaSoft.musalaSoft.entity.Drone;

import java.util.List;

public interface DroneService {
    List<Drone> getAllDrones();
    Drone getDroneById(Long id);
    Drone saveDrone(Drone drone);
    Drone updateDrone(Long id, Drone drone);
    Drone deleteDrone(Long id);
    Drone deleteDrone(Drone drone);
}
