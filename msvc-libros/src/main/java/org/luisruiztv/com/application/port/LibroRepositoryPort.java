package org.luisruiztv.com.application.port;

import org.luisruiztv.com.domain.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroRepositoryPort {
    List<Libro>     listar();
    Optional<Libro> buscarPorId(Long id);
    Libro           guardarLibro(Libro libro);
    void            borrarLibro(Long id);
}
