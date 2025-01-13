package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="file")
public class File implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private byte[] file;
    private LocalDateTime createFile;
    private LocalDateTime updateFile;
    @Enumerated(EnumType.STRING)
    private String state;
    private String format;
    @ManyToMany
    @JoinColumn(name="disease_id")
    private List<Disease> disease;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file1 = (File) o;
        return Objects.equals(id, file1.id) && Objects.equals(name, file1.name) && Objects.deepEquals(file, file1.file) && Objects.equals(createFile, file1.createFile) && Objects.equals(updateFile, file1.updateFile) && Objects.equals(state, file1.state) && Objects.equals(format, file1.format) && Objects.equals(disease, file1.disease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Arrays.hashCode(file), createFile, updateFile, state, format, disease);
    }
}