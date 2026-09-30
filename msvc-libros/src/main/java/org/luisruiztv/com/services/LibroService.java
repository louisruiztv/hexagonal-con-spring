package org.luisruiztv.com.services;

import com.fasterxml.jackson.annotation.OptBoolean;
import org.luisruiztv.com.models.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    List<Libro> findAll();
    Optional<Libro> findById(long id);
    Libro guardarLibro(Libro libro);
    Optional<Libro> actualizarLibro(Long id, Libro libro);
    void borrarLibro(Long id);
}
