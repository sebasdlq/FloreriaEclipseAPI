package com.seb.floreriaeleclipse.services.implementations;

import com.seb.floreriaeleclipse.dtos.FlorDto;
import com.seb.floreriaeleclipse.entities.Atributos;
import com.seb.floreriaeleclipse.entities.Flor;
import com.seb.floreriaeleclipse.entities.Lugar;
import com.seb.floreriaeleclipse.exceptions.ResourceNotFoundException;
import com.seb.floreriaeleclipse.mappers.FlorMapper;
import com.seb.floreriaeleclipse.repositories.AtributoRepository;
import com.seb.floreriaeleclipse.repositories.FlorRepository;
import com.seb.floreriaeleclipse.repositories.LugarRepository;
import com.seb.floreriaeleclipse.services.FlorService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FlorServiceImplementations implements FlorService {
    @Autowired
    private LugarRepository lugarRepository;
    @Autowired
    private AtributoRepository atributoRepository;
    @Autowired
    private FlorRepository florRepository;

    @Override
    public FlorDto createFlor(FlorDto florDto) {
        Flor flor = FlorMapper.dtoToFlor(florDto);

        Lugar lugar = lugarRepository.findById(florDto.getOrigenId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Lugar no encontrado id: " + florDto.getOrigenId())
                );
        flor.setLugarDeOrigen(lugar);

        List<Atributos> atributos =
                florDto.getAtributos().stream().map(
                        atributoDto -> {
                            return atributoRepository.findById(atributoDto.getId())
                                    .orElseThrow(
                                            () -> new ResourceNotFoundException("Atributo no encontrado id: " + atributoDto.getId())
                                    );
                        }
                ).toList();
        flor.setAtributos(atributos);
        Flor savedFlor = florRepository.save(flor);
        return FlorMapper.florToDto(savedFlor);
    }

    @Override
    public List<FlorDto> getAllFlors() {
        List<Flor> flores = florRepository.findAll();
        return flores.stream().map(
                FlorMapper::florToDto
        ).collect(Collectors.toList());
    }

    @Override
    public FlorDto getFlorById(Long id) {
        Flor flor = florRepository.findById(id).
                orElseThrow(
                        () -> new ResourceNotFoundException("Flor no existe, id: " + id)
                );
        return FlorMapper.florToDto(flor);
    }

    @Override
    @Transactional
    public FlorDto updateFlor(FlorDto florDto) {
        Flor florToUpdate = florRepository.findById(florDto.getId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Flor no existe, id: " + florDto.getId())
                );
        florToUpdate.setNombre(florDto.getNombre());
        florToUpdate.setDescripcion(florDto.getDescripcion());
        Lugar lugar = lugarRepository.findById(florDto.getOrigenId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Lugar no encontrado id: " + florDto.getOrigenId())
                );
        florToUpdate.setLugarDeOrigen(lugar);

        List<Atributos> atributos =
                florDto.getAtributos().stream().map(
                        atributoDto -> {
                            return atributoRepository.findById(atributoDto.getId())
                                    .orElseThrow(
                                            () -> new ResourceNotFoundException("Atributo no encontrado id: " + atributoDto.getId())
                                    );
                        }
                ).collect(Collectors.toList());
        florToUpdate.setAtributos(atributos);
        Flor savedFlor = florRepository.save(florToUpdate);
        return FlorMapper.florToDto(savedFlor);
    }

    @Override
    public void deleteFlor(Long id) {
        Flor flor = florRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Flor no existe, id: " + id)
                );
        florRepository.delete(flor);
    }
}
