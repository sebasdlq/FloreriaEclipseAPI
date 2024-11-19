package com.seb.floreriaeleclipse.services;

import com.seb.floreriaeleclipse.dtos.FlorDto;

import java.util.List;

public interface FlorService {
    FlorDto createFlor(FlorDto florDto);
    List<FlorDto> getAllFlors();
    FlorDto getFlorById(Long id);
    FlorDto updateFlor(FlorDto florDto);
    void deleteFlor(Long id);
}
