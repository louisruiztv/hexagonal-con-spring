package org.luisruiztv.com.infrastucture.controller;

import org.luisruiztv.com.application.service.LibroService;
import org.luisruiztv.com.domain.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.listar();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarPorId(@PathVariable Long id) {
        Optional<Libro> libro = libroService.buscarPorId(id);
        if(libro.isPresent()) {
            return ResponseEntity.ok(libro.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> guardarLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroService.guardarLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> ActualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Optional<Libro> libroActualizado = libroService.actualizar(id, libro);
        if(libroActualizado.isPresent()) {
            return ResponseEntity.ok(libroActualizado.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarLibro(@PathVariable Long id) {
        Optional<Libro> libroActual = libroService.buscarPorId(id);
        if(libroActual.isPresent()) {
            libroService.borrarLibro(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
