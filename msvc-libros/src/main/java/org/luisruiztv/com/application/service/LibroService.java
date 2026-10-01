package org.luisruiztv.com.application.service;

import org.luisruiztv.com.application.port.LibroRepositoryPort;
import org.luisruiztv.com.domain.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService{

    @Autowired
    private LibroRepositoryPort libroRepositoryPort;

    public List<Libro> listar() {
        return libroRepositoryPort.listar();
    }

    public Optional<Libro> buscarPorId(Long id) {
        return libroRepositoryPort.buscarPorId(id);
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepositoryPort.guardarLibro(libro);
    }

    public void borrarLibro(Long id) {
        libroRepositoryPort.borrarLibro(id);
    }

    public Optional<Libro> actualizar(Long id, Libro libro) {
        return libroRepositoryPort.buscarPorId(id).map(libroExistente -> {
            libroExistente.setTitulo(libro.getTitulo());
            libroExistente.setAutor(libro.getAutor());
            libroExistente.setAnioPublicacion(libro.getAnioPublicacion());
            return libroRepositoryPort.guardarLibro(libroExistente);
        });
    }

}
