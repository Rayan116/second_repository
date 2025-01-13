package com.example.demo.model;

import com.example.demo.model.enums.PatientGender;
import com.example.demo.model.enums.PatientRole;
import com.example.demo.model.enums.PatientState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "patients")
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 70)
    private String firstName;
    @Column(length = 100)
    private String lastName;
    @Enumerated(EnumType.STRING)
    private PatientGender gender;
    @Enumerated(EnumType.STRING)
    private PatientRole role;
    @Enumerated(EnumType.STRING)
    private PatientState state;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(unique = true, length = 150, nullable = false)
    private String email;
    private String address;
    private LocalDate birthday;
    @Transient
    private int age;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
    @ManyToMany
    @JoinTable(name = "patient_disease_assn",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "disease_id", referencedColumnName = "id"))
    private List<Disease> disease;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && age == patient.age && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(gender, patient.gender) && Objects.equals(phone, patient.phone) && Objects.equals(email, patient.email) && Objects.equals(address, patient.address) && Objects.equals(birthday, patient.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, gender, phone, email, address, birthday, age);
    }
}
