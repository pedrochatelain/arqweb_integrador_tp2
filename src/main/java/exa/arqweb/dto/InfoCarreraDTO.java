package exa.arqweb.dto;

import jakarta.persistence.*;
public class InfoCarreraDTO {

    private String carrera;
    private Integer anio;
    private Integer cant_inscriptos;
    private Integer cant_egresados;



    public InfoCarreraDTO() {}

    public InfoCarreraDTO(String carrera, Long anio, Long cant_inscriptos, Long cant_egresados) {
        this.carrera = carrera;
        if (anio != null)
            this.anio = anio.intValue();
        this.cant_inscriptos = cant_inscriptos.intValue();
        this.cant_egresados = cant_egresados.intValue();
    }

    public InfoCarreraDTO(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
//        return  "\nCarrera: " + carrera +
//                "\nAño: " + anio +
//                "\nInscriptos: " + cant_inscriptos +
//                "\nGraduados: " + cant_egresados;
        return
            "CARRERA: " + carrera + " - " +
            "ANIO: " + anio + " - " +
            "INSCRIPTOS: " + cant_inscriptos + " - " +
            "GRADUADOS: " + cant_egresados;
    }


}
