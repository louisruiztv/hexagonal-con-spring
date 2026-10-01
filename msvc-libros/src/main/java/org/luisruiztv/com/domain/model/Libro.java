package org.luisruiztv.com.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private Integer anioPublicacion;
}
