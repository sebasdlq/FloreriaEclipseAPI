package com.seb.floreriaeleclipse.services;

import com.seb.floreriaeleclipse.dtos.LugarDto;

import java.util.List;

public interface LugarService {
    LugarDto createLugar(LugarDto lugarDto);
    List<LugarDto> getLugars();
    LugarDto getLugarById(Long id);
    LugarDto updateLugar(LugarDto lugarDto);
    void deleteLugar(Long id);
}
