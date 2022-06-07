package com.example.promotions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {

    private int id;
    private String nombre;
    private String descripcion;
    private String fecha;
}
