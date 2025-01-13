package com.example.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class DiseaseDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
}
