package com.musalaSoft.musalaSoft.service.serviceIMPL;

import com.musalaSoft.musalaSoft.entity.Drone;
import com.musalaSoft.musalaSoft.entity.Medication;
import com.musalaSoft.musalaSoft.helper.DroneState;
import com.musalaSoft.musalaSoft.helper.Util;
import com.musalaSoft.musalaSoft.repository.DroneRepository;
import com.musalaSoft.musalaSoft.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DroneServiceIMPL implements DroneService {
    DroneRepository droneRepository;

    private Util util;
    @Autowired
    public DroneServiceIMPL(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public List<Drone> getAllDrones() {
        return (List<Drone>) droneRepository.findAll();
    }

    @Override
    public Drone getDroneById(Long id) {
        Optional<Drone> temp = droneRepository.findById(id);
        return temp.orElse(null);
    }

    @Override
    public Drone saveDrone(Drone drone) {
        if (Objects.nonNull(drone)) {
            if (util.isValidDroneModel(drone.getModel()) && util.isValidDroneState(drone.getState())) {
                return droneRepository.save(drone);
            }
        }
        return null;
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

    @Override
    public List<Medication> getMedicationsByDroneId(Long id) {
        Drone drone = droneRepository.findById(id).orElse(null);
        if (Objects.nonNull(drone)){
            return drone.getMedications();
        }
        return null;
    }

    @Override
    public int getBatteryLevelByDroneId(Long id) {
        Drone drone = droneRepository.findById(id).orElse(null);
        if (Objects.nonNull(drone)){
            return drone.getBatteryCapacity();
        }
        return 0;
    }

    @Override
    public List<Drone> getAvailableDronesToLoad() {
        return droneRepository.findByStateLikeIDLEOrLOADING().stream().toList();
    }

    @Override
    public Drone addMedicationToDrone(Long id, Medication medication) {
        Drone drone = droneRepository.findById(id).orElse(null);
        if (Objects.nonNull(drone)){
            double totalWeight = drone.getMedications().stream().parallel().map(Medication::getWeight)
                    .reduce((double) 0, Double::sum);
            if (totalWeight + medication.getWeight() < drone.getWeightLimit()){
                drone.getMedications().add(medication);
                droneRepository.save(drone);
            }
        }
        return drone;
    }

    @Override
    public Drone moveDroneToLoadingState(Long id) {
        Drone drone = droneRepository.findById(id).orElse(null);
        if (Objects.nonNull(drone)){
            if (drone.getBatteryCapacity() > 25){
                drone.setState(DroneState.LOADING.name());
            }
        }
        return drone;
    }


}
