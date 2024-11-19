package com.seb.floreriaeleclipse.services.implementations;

import com.seb.floreriaeleclipse.dtos.LugarDto;
import com.seb.floreriaeleclipse.entities.Lugar;
import com.seb.floreriaeleclipse.exceptions.ResourceNotFoundException;
import com.seb.floreriaeleclipse.mappers.LugarMapper;
import com.seb.floreriaeleclipse.repositories.LugarRepository;
import com.seb.floreriaeleclipse.services.LugarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LugarServiceImplementation implements LugarService {
    @Autowired
    private LugarRepository lugarRepository;

    @Override
    public LugarDto createLugar(LugarDto lugarDto) {
        Lugar lugar = new Lugar();
        lugar.setCiudad(lugarDto.getCiudad());
        lugar.setPais(lugarDto.getPais());
        lugar.setRegion(lugarDto.getRegion());
        Lugar lugarSaved = lugarRepository.save(lugar);
        return LugarMapper.lugarToDto(lugarSaved);
    }

    @Override
    public List<LugarDto> getLugars() {
        return lugarRepository.findAll().stream().map(LugarMapper::lugarToDto)
                .toList();
    }

    @Override
    public LugarDto getLugarById(Long id) {
        Lugar lugar = lugarRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Lugar no existe, id: " + id)
        );
        return LugarMapper.lugarToDto(lugar);
    }

    @Override
    public LugarDto updateLugar(LugarDto lugarDto) {
        Lugar lugar = lugarRepository.findById(lugarDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Lugar no existe, id: " + lugarDto.getId())
        );
        lugar.setCiudad(lugarDto.getCiudad());
        lugar.setPais(lugarDto.getPais());
        lugar.setRegion(lugarDto.getRegion());
        Lugar lugarSaved = lugarRepository.save(lugar);
        return LugarMapper.lugarToDto(lugarSaved);
    }

    @Override
    public void deleteLugar(Long id) {
        Lugar lugar = lugarRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Lugar no existe, id: " + id)
        );
        lugarRepository.delete(lugar);
    }
}
