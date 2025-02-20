package com.example.demo.dto;

import com.example.demo.model.enums.DiseaseState;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class DiseaseDto {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime start;
    private DiseaseState state;
}
