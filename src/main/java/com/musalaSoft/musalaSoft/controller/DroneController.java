package com.musalaSoft.musalaSoft.controller;

import com.musalaSoft.musalaSoft.entity.Drone;
import com.musalaSoft.musalaSoft.entity.Medication;
import com.musalaSoft.musalaSoft.service.DroneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/drone")
public class DroneController {

    DroneService droneService;

    @Autowired
    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @Operation(summary = "This is to get all drones in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "get all drones saved in database",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = " Page Not Found",
                    content = @Content)
    })
    @GetMapping()
    ResponseEntity<?> getAllDrones(){
        return new ResponseEntity<>(droneService.getAllDrones(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getDroneById(@PathVariable @NotBlank Long id){
        return new ResponseEntity<>(droneService.getDroneById(id), HttpStatus.OK);
    }
    @PostMapping()
    ResponseEntity<?> saveDrone(@RequestBody @Valid Drone drone){
        return new ResponseEntity<>(droneService.saveDrone(drone), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    ResponseEntity<?> updateDrone(@PathVariable @NotBlank Long id, @RequestBody @Valid Drone drone){
        return new ResponseEntity<>(droneService.updateDrone(id, drone), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteDrone(@PathVariable @NotBlank Long id){
        return new ResponseEntity<>(droneService.deleteDrone(id), HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/")
    ResponseEntity<?> deleteDrone(@RequestBody @Valid Drone drone){
        return new ResponseEntity<>(droneService.deleteDrone(drone), HttpStatus.NO_CONTENT);
    }

    @GetMapping("medication/{id}")
    ResponseEntity<?> getMedicationsByDroneId(@PathVariable @NotBlank Long id){
        return new ResponseEntity<>(droneService.getMedicationsByDroneId(id), HttpStatus.OK);
    }

    @GetMapping("batteryLevel/{id}")
    ResponseEntity<?> getBatteryLevelByDroneId(@PathVariable @NotBlank Long id){
        return new ResponseEntity<>(droneService.getBatteryLevelByDroneId(id), HttpStatus.OK);
    }

    @GetMapping("available")
    ResponseEntity<?> getAvailableDronesToLoad(){
        return new ResponseEntity<>(droneService.getAvailableDronesToLoad(), HttpStatus.OK);
    }

    @PatchMapping("addMedication/{id}")
    ResponseEntity<?> addMedicationToDrone(@PathVariable @NotBlank Long id, @RequestBody @Valid Medication medication){
        return new ResponseEntity<>(droneService.addMedicationToDrone(id, medication), HttpStatus.CREATED);
    }

    @PatchMapping("toLoad/{id}")
    ResponseEntity<?> moveDroneToLoadingState(@PathVariable @NotBlank Long id){
        return new ResponseEntity<>(droneService.moveDroneToLoadingState(id), HttpStatus.CREATED);
    }

}
