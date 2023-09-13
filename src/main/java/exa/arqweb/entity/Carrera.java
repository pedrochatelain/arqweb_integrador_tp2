package exa.arqweb.entity;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carrera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private List<Inscripcion> inscripciones;

    public Carrera() {
        this.inscripciones = new LinkedList<>();
    }

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

}
