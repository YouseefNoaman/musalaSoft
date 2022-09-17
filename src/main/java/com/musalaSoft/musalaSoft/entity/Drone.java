package com.musalaSoft.musalaSoft.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name="DRONE")
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Drone {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100, message = "Max serial number size is 100 characters.")
    @Column(name="SERIAL_NUMBER", nullable = false)
    private String serialNumber;

    @Column(name="MODEL", nullable = false)
    String model;

    @Max( value = 500, message = "Limit capacity of a drone is 500 grams.")
    @Column(name="WEIGHT_LIMIT", nullable = false)
    private double weightLimit;

    @Max(100)
    @Min(0)
    @Column(name="BATTERY_CAPACITY", nullable = false)
    private int batteryCapacity;

    @NotBlank
    @Column(name="STATE", nullable = false)
    private String state;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "DRONE_MEDICATION", joinColumns =
            {@JoinColumn(referencedColumnName = "ID")}
            , inverseJoinColumns = {@JoinColumn(referencedColumnName = "ID")})
    List<Medication> medications;
}