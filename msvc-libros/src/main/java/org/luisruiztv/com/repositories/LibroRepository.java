package org.luisruiztv.com.repositories;

import org.luisruiztv.com.models.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface LibroRepository extends CrudRepository<Libro, Long> {
}
