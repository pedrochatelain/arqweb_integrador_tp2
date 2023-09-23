package exa.arqweb.entity;

import exa.arqweb.dto.InfoCarreraDTO;
import exa.arqweb.utils.CarreraEstudianteKey;
import jakarta.persistence.*;

@Entity
@Table(name = "carrera_estudiante")
public class CarreraEstudiante {
    
    @EmbeddedId
    private CarreraEstudianteKey id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;
    
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    @Column
    private Integer anio_inscripcion;

    @Column
    private Integer anio_graduacion;

    public CarreraEstudiante() {}

    public CarreraEstudiante(Estudiante e, Carrera c, int anio_inscripcion) {
        this.id = new CarreraEstudianteKey(e.getID(), c.getID());
        this.estudiante = e;
        this.carrera = c;
        this.anio_inscripcion = anio_inscripcion;
    }

    public Integer getAnioInscripcion() {
        return anio_inscripcion;
    }

    public void setAnioGraduacion(Integer anio_graduacion) {
        this.anio_graduacion = anio_graduacion;
    }


}
