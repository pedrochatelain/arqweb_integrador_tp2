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
    private int antiguedad;

    public Inscripcion() {}

    public Inscripcion(Estudiante e, Carrera c) {
        this.estudiante = e;
        this.carrera = c;
        this.id = new InscripcionKey(e.getID(), c.getID());
    }

    public void setId(InscripcionKey id) {
        this.id = id;
    }

    public InscripcionKey getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
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
