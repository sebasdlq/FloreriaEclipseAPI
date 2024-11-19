package com.seb.floreriaeleclipse.controllers;

import com.seb.floreriaeleclipse.dtos.AtributoDto;
import com.seb.floreriaeleclipse.repositories.AtributoRepository;
import com.seb.floreriaeleclipse.services.AtributoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("api/atributos")

public class AtributoController {
    @Autowired
    private AtributoService atributoService;

    @PostMapping
    public ResponseEntity<AtributoDto> createAtributo(@RequestBody AtributoDto atributoDto) {
        AtributoDto atributo = atributoService.createAtributo(atributoDto);
        return ResponseEntity.ok(atributo);
    }
    @GetMapping
    public ResponseEntity<List<AtributoDto>> getAllAtributos() {
        return ResponseEntity.ok(atributoService.getAllAtributos());
    }
    @GetMapping("{id}")
    public ResponseEntity<AtributoDto> getAtributoById(@PathVariable Long id) {
        return ResponseEntity.ok(atributoService.getAtributo(id));
    }
    @PutMapping
    public ResponseEntity<AtributoDto> updateAtributo(@RequestBody AtributoDto atributoDto) {
        return ResponseEntity.ok(atributoService.updateAtributo(atributoDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAtributo(@PathVariable Long id) {
        atributoService.deleteAtributo(id);
        return ResponseEntity.ok("Atributo " + id + " eliminado.");
    }
}
