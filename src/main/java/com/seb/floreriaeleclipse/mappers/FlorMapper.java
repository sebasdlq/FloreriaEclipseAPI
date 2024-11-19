package com.seb.floreriaeleclipse.mappers;

import com.seb.floreriaeleclipse.dtos.FlorDto;
import com.seb.floreriaeleclipse.entities.Flor;

import java.util.stream.Collectors;

public class FlorMapper {
    public static Flor dtoToFlor(FlorDto florDto) {
        Flor flor = new Flor();
        flor.setId(florDto.getId());
        flor.setNombre(florDto.getNombre());
        flor.setDescripcion(florDto.getDescripcion());
        flor.setPrecio(florDto.getPrecio());
        flor.setImagen(florDto.getImagen());
        flor.setStock(florDto.getStock());
        return flor;
    }
    public static FlorDto florToDto(Flor flor) {
        return new FlorDto(
                flor.getId(),
                flor.getNombre(),
                flor.getDescripcion(),
                flor.getPrecio(),
                flor.getImagen(),
                flor.getStock(),
                flor.getLugarDeOrigen().getId(),
                flor.getAtributos().stream().map(
                        AtributoMapper::AtributoToDto
                ).collect(Collectors.toList())
        );
    }
}
