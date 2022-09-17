package com.musalaSoft.musalaSoft.repository;

import com.musalaSoft.musalaSoft.entity.Drone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {
}
