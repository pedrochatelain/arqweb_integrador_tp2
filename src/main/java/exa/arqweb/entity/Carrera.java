package exa.arqweb.entity;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrera {
    
    @Id
    private int id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private List<CarreraEstudiante> inscripciones;

    public Carrera() {
        this.inscripciones = new LinkedList<>();
    }

    public Carrera(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.inscripciones = new LinkedList<>();
    }

    public int getID() {
        return this.id;
    }

    public void addInscripcion(CarreraEstudiante i) {
        this.inscripciones.add(i);
    }

    @Override
    public String toString() {
        return "\nID: " + id +
        "\nNombre: " + nombre;
    }

}
