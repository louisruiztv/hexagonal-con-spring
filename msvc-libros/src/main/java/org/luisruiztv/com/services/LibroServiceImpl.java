package org.luisruiztv.com.services;

import org.luisruiztv.com.models.Libro;
import org.luisruiztv.com.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Libro> findAll() {
        return (List<Libro>) libroRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Libro> findById(long id) {
        return libroRepository.findById(id);
    }

    @Override
    @Transactional
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    @Transactional
    public Optional<Libro> actualizarLibro(Long id, Libro libro) {
        Optional<Libro> Opt = libroRepository.findById(id);
        if(Opt.isPresent()) {
            Libro Libro = Opt.get();
            Libro.setTitulo(libro.getTitulo());
            Libro.setAutor(libro.getAutor());
            Libro.setAnioPublicacion(libro.getAnioPublicacion());
            return Optional.of(libroRepository.save(Libro));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void borrarLibro(Long id) {
        libroRepository.findById(id).ifPresent(libro -> {libroRepository.delete(libro);});
    }


    /*
    * Otra forma de actualizar:
    *  return libroRepository.findById(id).map(
                libroActualizado -> {
                    libroActualizado.setTitulo(libro.getTitulo());
                    libroActualizado.setAutor(libro.getAutor());
                    libroActualizado.setAnioPublicacion(libro.getAnioPublicacion());
                    return libroRepository.save(libroActualizado);
                }
        );
    *
    * */
}
