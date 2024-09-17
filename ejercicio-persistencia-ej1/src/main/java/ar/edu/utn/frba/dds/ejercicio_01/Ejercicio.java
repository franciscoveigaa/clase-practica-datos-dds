package ar.edu.utn.frba.dds.ejercicio_01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ejercicio")
public class Ejercicio {
    @Column(name="nombre")
    private String nombre;
    @Column(name="detalle", columnDefinition = "TEXT")
    private String detalle;
}
