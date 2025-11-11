package com.utn.productos.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    // Fecha y hora del error
    private LocalDateTime timestamp;

    // Código de estado HTTP
    private Integer status;

    // Mensaje descriptivo del error
    private String mensaje;

    // Ruta de la petición que generó el error
    private String ruta;

    // Constructor con timestamp automático
    public ErrorResponse(Integer status, String mensaje, String ruta) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.mensaje = mensaje;
        this.ruta = ruta;
    }
}