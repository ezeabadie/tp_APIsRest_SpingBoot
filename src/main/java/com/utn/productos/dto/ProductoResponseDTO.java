package com.utn.productos.dto;

import com.utn.productos.model.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO de respuesta con información completa del producto")
public class ProductoResponseDTO {

    @Schema(description = "Identificador único del producto", example = "1")
    private Long id;

    @Schema(description = "Nombre del producto", example = "Laptop HP")
    private String nombre;

    @Schema(description = "Descripción detallada del producto", example = "Laptop HP con 16GB RAM y 512GB SSD")
    private String descripcion;

    @Schema(description = "Precio del producto en pesos", example = "1500.00")
    private Double precio;

    @Schema(description = "Cantidad disponible en stock", example = "50")
    private Integer stock;

    @Schema(description = "Categoría del producto", example = "ELECTRONICA")
    private Categoria categoria;
}