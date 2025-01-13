package com.example.demo.dto;

import jakarta.persistence.Lob;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class FileDto {
    private Long id;
    private String name;

}
