package com.seb.floreriaeleclipse.controllers;

import com.seb.floreriaeleclipse.dtos.LugarDto;
import com.seb.floreriaeleclipse.services.LugarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/lugares")
public class LugarController {
    @Autowired
    private LugarService lugarService;

    @PostMapping
    ResponseEntity<LugarDto> createLugar(@RequestBody LugarDto lugarDto) {
        LugarDto result = lugarService.createLugar(lugarDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    ResponseEntity<List<LugarDto>> getAllLugars() {
        return ResponseEntity.ok(lugarService.getLugars());
    }

    @GetMapping("{id}")
    ResponseEntity<LugarDto> getLugarById(@PathVariable Long id) {
        return ResponseEntity.ok(lugarService.getLugarById(id));
    }

    @PutMapping
    ResponseEntity<LugarDto> updateLugar(@RequestBody LugarDto lugarDto) {
        LugarDto result = lugarService.updateLugar(lugarDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    ResponseEntity<String> deleteLugarById(@PathVariable Long id) {
        lugarService.deleteLugar(id);
        return ResponseEntity.ok("Lugar deletado com sucesso! " + id);
    }
}
