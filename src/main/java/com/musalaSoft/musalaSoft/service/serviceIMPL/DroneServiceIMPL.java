package com.musalaSoft.musalaSoft.service.serviceIMPL;

import com.musalaSoft.musalaSoft.entity.Drone;
import com.musalaSoft.musalaSoft.repository.DroneRepository;
import com.musalaSoft.musalaSoft.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class DroneServiceIMPL implements DroneService {
    DroneRepository droneRepository;

    @Autowired
    public DroneServiceIMPL(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    @Override
    public Drone getDroneById(Long id) {
        Optional<Drone> temp = droneRepository.findById(id);
        return temp.orElse(null);
    }

    @Override
    public Drone saveDrone(Drone Drone) {
        return droneRepository.save(Drone);
    }

    @Override
    public Drone updateDrone(Long id, Drone drone) {
        Drone temp = getDroneById(id);
        if(Objects.nonNull(temp)){
            drone.setId(temp.getId());
            droneRepository.save(drone);
        }
        return drone;
    }

    @Override
    public Drone deleteDrone(Long id) {
        Drone temp = getDroneById(id);
        if(Objects.nonNull(temp)){
            droneRepository.deleteById(id);
        }
        return temp;
    }

    @Override
    public Drone deleteDrone(Drone drone){
        droneRepository.delete(drone);
        return drone;
    }

}
