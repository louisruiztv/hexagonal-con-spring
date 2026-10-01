package org.luisruiztv.com.infrastucture.repository;

import org.luisruiztv.com.infrastucture.entity.LibroEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibroCrudRepository extends CrudRepository<LibroEntity, Long> {
    List<LibroEntity> findAll();
}
