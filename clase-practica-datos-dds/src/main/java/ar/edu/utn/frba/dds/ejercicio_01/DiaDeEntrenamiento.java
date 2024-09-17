package ar.edu.utn.frba.dds.ejercicio_01;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="dia_de_entrenamiento")
public class DiaDeEntrenamiento {

  @ManyToMany
  @JoinTable(
    name="dia_de_entrenamiento_ejercicio",
    joinColumns=@JoinColumn(name="dia_de_entrenamiento_id"),
    inverseJoinColumns=@JoinColumn(name="ejercicio_id")
  )
  private List<Ejercicio> ejercicios;
  @Column(name="numero")
  private Integer numero; // representa el orden en la duracion de la rutina.
  @OneToOne
  @JoinColumn(name="dia_siguiente_id")
  private DiaDeEntrenamiento siguienteDia;

  public DiaDeEntrenamiento() {
    this.ejercicios = new ArrayList<>();
  }
  public void agregarEjercicio(Ejercicio ejercicio) {
    this.ejercicios.add(ejercicio);
  }
}
