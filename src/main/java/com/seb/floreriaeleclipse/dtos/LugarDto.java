package com.seb.floreriaeleclipse.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class LugarDto {
    private Long id;

    private String pais;
    private String region;
    private String ciudad;
}
