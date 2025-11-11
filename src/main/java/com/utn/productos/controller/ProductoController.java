package com.utn.productos.controller;

import com.utn.productos.dto.ActualizarStockDTO;
import com.utn.productos.dto.ProductoDTO;
import com.utn.productos.dto.ProductoResponseDTO;
import com.utn.productos.model.Categoria;
import com.utn.productos.model.Producto;
import com.utn.productos.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    // GET - Listar todos
    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> listarTodos() {
        List<ProductoResponseDTO> productos = productoService.obtenerTodos()
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productos);
    }

    // GET - Obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> obtenerPorId(@PathVariable Long id) {
        Producto producto = productoService.obtenerPorId(id);
        return ResponseEntity.ok(convertirAResponse(producto));
    }

    // GET - Filtrar por categoría
    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<ProductoResponseDTO>> obtenerPorCategoria(@PathVariable Categoria categoria) {
        List<ProductoResponseDTO> productos = productoService.obtenerPorCategoria(categoria)
                .stream()
                .map(this::convertirAResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(productos);
    }

    // POST - Crear producto
    @PostMapping
    public ResponseEntity<ProductoResponseDTO> crearProducto(@Valid @RequestBody ProductoDTO productoDTO) {
        Producto producto = convertirAEntidad(productoDTO);
        Producto productoGuardado = productoService.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertirAResponse(productoGuardado));
    }

    // PUT - Actualizar completo
    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody ProductoDTO productoDTO) {
        Producto productoActualizado = convertirAEntidad(productoDTO);
        Producto producto = productoService.actualizarProducto(id, productoActualizado);
        return ResponseEntity.ok(convertirAResponse(producto));
    }

    // PATCH - Actualizar solo stock
    @PatchMapping("/{id}/stock")
    public ResponseEntity<ProductoResponseDTO> actualizarStock(
            @PathVariable Long id,
            @Valid @RequestBody ActualizarStockDTO stockDTO) {
        Producto producto = productoService.actualizarStock(id, stockDTO.getStock());
        return ResponseEntity.ok(convertirAResponse(producto));
    }

    // DELETE - Eliminar producto
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
    }

    // Convierte DTO a entidad
    private Producto convertirAEntidad(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoria(dto.getCategoria());
        return producto;
    }

    // Convierte entidad a ResponseDTO
    private ProductoResponseDTO convertirAResponse(Producto producto) {
        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getCategoria()
        );
    }
}