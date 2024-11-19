package com.seb.floreriaeleclipse.controllers;

import com.seb.floreriaeleclipse.dtos.FlorDto;
import com.seb.floreriaeleclipse.services.FlorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/flores")

public class FlorController {
    @Autowired
    private FlorService florService;

    @PostMapping
    public ResponseEntity<FlorDto> createFlor(@RequestBody FlorDto florDto) {
        FlorDto result = florService.createFlor(florDto);
        return ResponseEntity.ok(result);
    }
    @GetMapping
    public ResponseEntity<List<FlorDto>> getAllFlors() {
        List<FlorDto> result = florService.getAllFlors();
        return ResponseEntity.ok(result);
    }
    @GetMapping("{id}")
    public ResponseEntity<FlorDto> getFlorById(@PathVariable Long id) {
        FlorDto dto = florService.getFlorById(id);
        return ResponseEntity.ok(dto);
    }
    @PutMapping
    public ResponseEntity<FlorDto> updateFlor(@RequestBody FlorDto florDto) {
        FlorDto result = florService.updateFlor(florDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFlor(@PathVariable Long id) {
        florService.deleteFlor(id);
        return ResponseEntity.ok("Flor " + id + " eliminado");
    }
}
