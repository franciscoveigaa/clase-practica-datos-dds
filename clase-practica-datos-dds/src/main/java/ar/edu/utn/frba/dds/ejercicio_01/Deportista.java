package ar.edu.utn.frba.dds.ejercicio_01;

import ar.edu.utn.frba.dds.ejercicio_01.converters.MotivacionConverter;
import ar.edu.utn.frba.dds.ejercicio_01.motivaciones.Motivacion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Table(name="deportista")
public class Deportista extends Persistente {
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @ElementCollection
    @CollectionTable(name="contactos_deportista", joinColumns= @JoinColumn(name="deportista_id"))
    @Column(name="contacto")
    private List<String> contactos;
    @Convert(converter=MotivacionConverter.class)
    @Column(name="motivacion")
    private Motivacion motivacionPrincipal;
    @Column(name="peso_inicial_kg")
    private Double pesoInicialEnKilos;

    public void agregarContacto(String contacto) {
        contactos.add(contacto);
    }

    public Deportista(){
        this.contactos = new ArrayList<>();
    }

}
