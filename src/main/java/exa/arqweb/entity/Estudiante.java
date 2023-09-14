package exa.arqweb.entity;

import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Estudiante {

    @Id
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int edad;

    @Column
    private String genero;

    @Column
    private int dni;

    @Column
    private String ciudad;

    @Column
    private int legajo;

    @OneToMany(mappedBy = "estudiante")
    private List<Inscripcion> inscripciones;

    @Column
    private boolean esGraduado;

    public Estudiante() {
        this.inscripciones = new LinkedList<>();
    }
    
    public Estudiante
    (int id, String nombre, String apellido, int edad,
    String genero, int dni, String ciudad, int legajo, boolean esGraduado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.dni = dni;
        this.ciudad = ciudad;
        this.legajo = legajo;
        this.esGraduado = esGraduado;
        this.inscripciones = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido
        + "\nEdad: " + edad + "\nGénero: " + genero + "\nDNI: "
        + dni + "\nCiudad: " + ciudad + "\nLegajo: " + legajo +
        "\nEs graduado: " + esGraduado;
    }

    public int getID() {
        return this.id;
    }

}
