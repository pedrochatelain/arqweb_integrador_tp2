package exa.arqweb.repository;

import java.util.List;

import exa.arqweb.dto.CarrerasConInscriptosDTO;
import exa.arqweb.dto.InfoCarreraDTO;
import exa.arqweb.entity.Carrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CarreraRepository {

    private EntityManager em;

    private static CarreraRepository instance = null;

    private CarreraRepository() {}

    public static CarreraRepository getInstance(EntityManager em) {
        if (instance == null) {
            instance = new CarreraRepository();
            instance.em = em;
        }
        return instance;
    }

    public void add(Carrera c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    // f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
    public List<CarrerasConInscriptosDTO> getCarrerasConInscriptos() {
        String statement = """
            SELECT new exa.arqweb.dto.CarrerasConInscriptosDTO(c.id, c.nombre, COUNT(c.id))
            FROM Carrera c JOIN CarreraEstudiante ce ON c.id = ce.carrera.id
            GROUP BY c.id
            ORDER BY COUNT(c.id)
        """;
        TypedQuery<CarrerasConInscriptosDTO> query = em.createQuery(statement, CarrerasConInscriptosDTO.class);
        return query.getResultList();
    }

//    3) Generar un reporte de las carreras, que para cada carrera incluya información de los
//    inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
//    los años de manera cronológica.
    public List<InfoCarreraDTO> getReporteCarreras() {
        String statement = """
            SELECT nombre AS carrera, anio_graduacion AS anio, MAX(cant_inscriptos) AS cant_inscriptos, MAX(cant_graduados) AS cant_egresados
            FROM (
                 SELECT c.nombre, anio_graduacion, COUNT(anio_graduacion) AS cant_graduados, 0 AS cant_inscriptos
                 FROM carrera c LEFT JOIN carrera_estudiante ce ON ce.id_carrera = c.id
                 WHERE anio_graduacion IS NOT NULL
                 GROUP BY c.id, anio_graduacion
                 UNION (
                     SELECT c.nombre, anio_inscripcion, 0, COUNT(anio_inscripcion) AS cant_inscriptos
                     FROM carrera c LEFT JOIN carrera_estudiante ce ON ce.id_carrera = c.id
                     GROUP BY c.id, anio_inscripcion
                 )
            ) graduados_inscriptos
            GROUP BY nombre, anio
            ORDER BY nombre, anio
        """;
        Query query = em.createNativeQuery(statement, "info_carrera_dto_mapping_xml");
        return query.getResultList();
    }

}
