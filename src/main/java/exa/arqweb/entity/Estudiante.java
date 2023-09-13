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

    public int getID() {
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public boolean esGraduado() {
        return esGraduado;
    }

    public void setGraduado(boolean esGraduado) {
        this.esGraduado = esGraduado;
    }

    public void addInscripcion(Inscripcion i) {
        this.inscripciones.add(i);
    }

    @Override
    public String toString() {
        return "\nID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido
        + "\nEdad: " + edad + "\nGénero: " + genero + "\nDNI: "
        + dni + "\nCiudad: " + ciudad + "\nLegajo: " + legajo +
        "\nEs graduado: " + esGraduado;
    }

}
