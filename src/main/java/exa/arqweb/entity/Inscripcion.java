package exa.arqweb.entity;

import exa.arqweb.utils.InscripcionKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Inscripcion {
    
    @EmbeddedId
    private InscripcionKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
    
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @Column
    private int antiguedad;

    public Inscripcion() {}

    public Inscripcion(Estudiante e, Carrera c) {
        this.estudiante = e;
        this.carrera = c;
    }

}
