package com.example.demo.model;


import com.example.demo.model.enums.DiseaseState;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "disease")
public class Disease implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime start;
    @Enumerated(EnumType.STRING)
    private DiseaseState state;
    @OneToMany (cascade={CascadeType.ALL},mappedBy = "disease")
    @JsonManagedReference
    @ToString.Exclude
    private List<File> files;
    @ManyToMany(mappedBy = "diseases")
    @ToString.Exclude
    private List<Patient> patients;
}
