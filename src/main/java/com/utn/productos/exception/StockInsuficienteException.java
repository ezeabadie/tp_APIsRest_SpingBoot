package com.utn.productos.exception;

public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(Long productoId, Integer stockActual, Integer stockSolicitado) {
        super(String.format("Stock insuficiente para el producto ID %d. Stock actual: %d, solicitado: %d",
                productoId, stockActual, stockSolicitado));
    }

    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}