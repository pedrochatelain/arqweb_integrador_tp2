package exa.arqweb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
    private int anio_inscripcion;

    public Inscripcion() {}

    public Inscripcion(Estudiante e, Carrera c, int anio_inscripcion) {
        this.id = new InscripcionKey(e.getID(), c.getID());
        this.estudiante = e;
        this.carrera = c;
        this.anio_inscripcion = anio_inscripcion;
    }

    @Embeddable
    private class InscripcionKey {
        @Column(name = "id_estudiante")
        private int idEstudiante;
        
        @Column(name = "id_carrera")
        private int idCarrera;

        public InscripcionKey(int idEstudiante, int idCarrera) {
            this.idEstudiante = idEstudiante;
            this.idCarrera = idCarrera;
        }
    }

}
