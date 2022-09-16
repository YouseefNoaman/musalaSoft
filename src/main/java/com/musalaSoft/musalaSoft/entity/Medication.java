package com.musalaSoft.musalaSoft.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="MEDICATION")
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Medication {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name="NAME", nullable = false)
    private String name;

    @Lob
    @Column(name="IMAGE", nullable = false)
    byte[] image;

    @Column(name="WEIGHT", nullable = false)
    private double weight;

    @Column(name="CODE", nullable = false)
    private String code;

    public Medication(String name, byte[] image, double weight, String code) {
        this.name = name;
        this.image = image;
        this.weight = weight;
        this.code = code;
    }
}