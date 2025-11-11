package com.utn.productos.service;

import com.utn.productos.exception.ProductoNotFoundException;
import com.utn.productos.exception.StockInsuficienteException;
import com.utn.productos.model.Categoria;
import com.utn.productos.model.Producto;
import com.utn.productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    // Guarda nuevo producto
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Retorna todos los productos
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    // Busca por ID
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    // Filtra por categoría
    public List<Producto> obtenerPorCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    // Actualiza producto si existe
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(productoActualizado.getNombre());
                    producto.setDescripcion(productoActualizado.getDescripcion());
                    producto.setPrecio(productoActualizado.getPrecio());
                    producto.setStock(productoActualizado.getStock());
                    producto.setCategoria(productoActualizado.getCategoria());
                    return productoRepository.save(producto);
                })
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    // Actualiza solo stock
    public Producto actualizarStock(Long id, Integer nuevoStock) {
        return productoRepository.findById(id)
                .map(producto -> {
                    if (nuevoStock < 0) {
                        throw new StockInsuficienteException(
                                id, producto.getStock(), nuevoStock);
                    }
                    producto.setStock(nuevoStock);
                    return productoRepository.save(producto);
                })
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    // Elimina si existe
    public void eliminarProducto(Long id) {
                Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
        productoRepository.deleteById(id);
    }
}