package com.musalaSoft.musalaSoft.scheduler;

import com.musalaSoft.musalaSoft.entity.Drone;
import com.musalaSoft.musalaSoft.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SchedulerService {
    static final Logger LOGGER =
            Logger.getLogger(SchedulerService.class.getName());

    DroneService droneService;

    @Autowired
    public SchedulerService(DroneService droneService) {
        this.droneService = droneService;
    }

    @Async
    @Scheduled(cron = "${interval}")
    public void dronesBatteryLevels() throws InterruptedException {
        List<Drone> drones = droneService.getAllDrones();
        LOGGER.info(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) + " Drones Battery Levels: ");
        for (Drone drone: drones) {
            LOGGER.info(" Drone ID: " + drone.getId() + " drone serial number: " + drone.getSerialNumber()
            + " drone battery level: " + drone.getBatteryCapacity());
        }
    }
}
