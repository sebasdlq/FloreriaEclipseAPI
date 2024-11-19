package com.seb.floreriaeleclipse.mappers;

import com.seb.floreriaeleclipse.dtos.AtributoDto;
import com.seb.floreriaeleclipse.entities.Atributos;

public class AtributoMapper {
    public static Atributos dtoToAtributo(AtributoDto dto){
        return new Atributos(
                dto.getId(),
                dto.getName(),
                dto.getDescription()
        );
    }

    public static AtributoDto AtributoToDto(Atributos a){
        return new AtributoDto(
                a.getId(),
                a.getName(),
                a.getDescription()
            );
    }
}
