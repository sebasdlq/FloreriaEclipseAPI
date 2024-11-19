package com.seb.floreriaeleclipse.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class AtributoDto {
    private Long id;
    private String name;
    private String description;
}
