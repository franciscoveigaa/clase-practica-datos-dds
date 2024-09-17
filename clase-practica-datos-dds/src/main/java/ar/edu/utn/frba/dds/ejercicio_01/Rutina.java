package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="rutina")
public class Rutina extends Persistente {

    @ManyToOne
    @JoinColumn(name="deportista_id")
    private Deportista deportista;
    @OneToMany
    @JoinColumn(name="rutina_id")
    private List<DiaDeEntrenamiento> diasDeEntrenamiento;
    @OneToOne
    @JoinColumn(name="rutina_anterior_id")
    private Rutina rutinaAnterior;

    public Rutina() {
        this.diasDeEntrenamiento = new ArrayList<>();
    }

    public void agregarDiaDeEntrenamiento(DiaDeEntrenamiento diaDeEntrenamiento) {
        this.diasDeEntrenamiento.add(diaDeEntrenamiento);
    }
}
