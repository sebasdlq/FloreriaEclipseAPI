package com.seb.floreriaeleclipse.mappers;

import com.seb.floreriaeleclipse.dtos.LugarDto;
import com.seb.floreriaeleclipse.entities.Lugar;

public class LugarMapper {
    public static Lugar dtoToLugar(LugarDto dto) {
        return new Lugar(
                dto.getId(),
                dto.getPais(),
                dto.getRegion(),
                dto.getCiudad()
        );
    }

    public static LugarDto lugarToDto(Lugar lugar) {
        return new LugarDto(
                lugar.getId(),
                lugar.getPais(),
                lugar.getRegion(),
                lugar.getCiudad()
        );
    }
}
