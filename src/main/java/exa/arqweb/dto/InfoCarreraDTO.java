package exa.arqweb.dto;

public class InfoCarreraDTO {

    private String carrera;
    private int anio;
    private int cantInscriptos;
    private int cantEgresados;

    public InfoCarreraDTO(String carrera, int anio, int cantInscriptos, int cantEgresados) {
        this.carrera = carrera;
        this.anio = anio;
        this.cantInscriptos = cantInscriptos;
        this.cantEgresados = cantEgresados;
    }


}
