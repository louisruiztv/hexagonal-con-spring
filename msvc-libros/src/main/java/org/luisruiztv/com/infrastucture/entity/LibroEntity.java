package org.luisruiztv.com.infrastucture.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "libro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class LibroEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="titulo", nullable = false, length=100)
    private String titulo;

    @Column(name="autor", nullable = false, length=100)
    private String autor;

    @Column(name="anio_publicacion", nullable = false, length=100)
    private Integer anioPublicacion;
}
