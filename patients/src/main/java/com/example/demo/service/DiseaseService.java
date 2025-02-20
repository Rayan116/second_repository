package com.example.demo.service;

import com.example.demo.dto.DiseaseDto;

import java.util.List;

public interface DiseaseService {
    List<DiseaseDto> getAllDisease();

    DiseaseDto updateDisease(DiseaseDto disease);

    DiseaseDto addDisease(DiseaseDto disease);

}
