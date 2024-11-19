package com.seb.floreriaeleclipse.services.implementations;

import com.seb.floreriaeleclipse.dtos.AtributoDto;
import com.seb.floreriaeleclipse.entities.Atributos;
import com.seb.floreriaeleclipse.exceptions.ResourceNotFoundException;
import com.seb.floreriaeleclipse.mappers.AtributoMapper;
import com.seb.floreriaeleclipse.repositories.AtributoRepository;
import com.seb.floreriaeleclipse.services.AtributoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AtributoServiceImplementation implements AtributoService {
    @Autowired
    private AtributoRepository atributoRepository;

    @Override
    public AtributoDto createAtributo(AtributoDto atributo) {
        Atributos a = new Atributos();
        a.setName(atributo.getName());
        a.setDescription(atributo.getDescription());
        Atributos savedA = atributoRepository.save(a);
        return AtributoMapper.AtributoToDto(savedA);
    }

    @Override
    public List<AtributoDto> getAllAtributos() {
        List<Atributos> atributos = atributoRepository.findAll();
        return atributos.stream().map(
                AtributoMapper::AtributoToDto
        ).toList();
    }

    @Override
    public AtributoDto getAtributo(Long id) {
        Atributos atributo = atributoRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Atributo id : "+ id)
                );
        return AtributoMapper.AtributoToDto(atributo);
    }

    @Override
    public AtributoDto updateAtributo(AtributoDto atributoDto) {
        Atributos atributo = atributoRepository.findById(atributoDto.getId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Atributo id : "+ atributoDto.getId())
                );
        atributo.setName(atributoDto.getName());
        atributo.setDescription(atributoDto.getDescription());
        Atributos savedA = atributoRepository.save(atributo);
        return AtributoMapper.AtributoToDto(savedA);
    }

    @Override
    public void deleteAtributo(Long id) {
        Atributos atributo = atributoRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Atributo id : "+ id)
                );
        atributoRepository.delete(atributo);
    }
}
