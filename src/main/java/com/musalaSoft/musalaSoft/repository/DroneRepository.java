package com.musalaSoft.musalaSoft.repository;

import com.musalaSoft.musalaSoft.entity.Drone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {
    @Query(value = "SELECT * FROM DRONE d WHERE d.state LIKE 'IDLE' OR d.state LIKE 'LOADING'", nativeQuery = true)
    List<Drone> findByStateLikeIDLEOrLOADING();
}
