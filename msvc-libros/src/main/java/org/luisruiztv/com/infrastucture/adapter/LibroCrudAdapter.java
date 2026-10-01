package org.luisruiztv.com.infrastucture.adapter;

import org.luisruiztv.com.application.port.LibroRepositoryPort;
import org.luisruiztv.com.domain.model.Libro;
import org.luisruiztv.com.infrastucture.entity.LibroEntity;
import org.luisruiztv.com.infrastucture.repository.LibroCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class LibroCrudAdapter implements LibroRepositoryPort {

    @Autowired
    private LibroCrudRepository libroCrudRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Libro> listar() {
        return libroCrudRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Libro> buscarPorId(Long id) {
        return libroCrudRepository.findById(id).map(this::toDomain);
    }

    @Override
    @Transactional
    public Libro guardarLibro(Libro libro) {
        LibroEntity entity = toEntity(libro);
        LibroEntity guardado = libroCrudRepository.save(entity);
        return toDomain(guardado);
    }

    @Override
    @Transactional
    public void borrarLibro(Long id) {
        libroCrudRepository.deleteById(id);
    }


    public Libro toDomain(LibroEntity libroEntity) {
        return new Libro(libroEntity.getId(), libroEntity.getTitulo(), libroEntity.getAutor(), libroEntity.getAnioPublicacion());
    }

    public LibroEntity toEntity(Libro libro) {
        return new LibroEntity(libro.getId(), libro.getTitulo(), libro.getAutor(), libro.getAnioPublicacion());
    }
}
