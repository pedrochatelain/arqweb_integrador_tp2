package exa.arqweb.utils;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class InscripcionKey {

    @Column(name = "id_estudiante")
    private int idEstudiante;

    @Column(name = "id_carrera")
    private int idCarrera;

}
