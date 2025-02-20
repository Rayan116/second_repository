package com.example.demo.model;


import com.example.demo.model.enums.DiseaseState;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "disease", schema = "public")
public class Disease implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime start;
    @Enumerated(EnumType.STRING)
    private DiseaseState state;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "patients_disease",
            joinColumns = @JoinColumn(name = "disease_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patients_id", referencedColumnName = "id"))
    private List<Patient> patients;
}
