package ar.edu.utn.frba.dds.ejercicio_01;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
@MappedSuperclass
public class Persistente {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="fecha_creacion")
    private LocalDateTime fecha_creacion;

    @Column(name="activo")
    private Boolean activo;
}