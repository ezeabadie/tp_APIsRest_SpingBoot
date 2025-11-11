package com.utn.productos.dto;

import com.utn.productos.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseDTO {

    // ID del producto
    private Long id;

    // Nombre del producto
    private String nombre;

    // Descripción del producto
    private String descripcion;

    // Precio del producto
    private Double precio;

    // Stock disponible
    private Integer stock;

    // Categoría del producto
    private Categoria categoria;
}