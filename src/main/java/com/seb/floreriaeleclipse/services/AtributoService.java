package com.seb.floreriaeleclipse.services;

import com.seb.floreriaeleclipse.dtos.AtributoDto;

import java.util.List;

public interface AtributoService {
    AtributoDto createAtributo(AtributoDto atributo);
    List<AtributoDto> getAllAtributos();
    AtributoDto getAtributo(Long id);
    AtributoDto updateAtributo(AtributoDto atributoDto);
    void deleteAtributo(Long id);
}
