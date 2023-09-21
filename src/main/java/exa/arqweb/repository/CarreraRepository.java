package exa.arqweb.repository;

import java.util.List;

import exa.arqweb.dto.CarrerasConInscriptosDTO;
import exa.arqweb.dto.InfoCarreraDTO;
import exa.arqweb.entity.Carrera;
import exa.arqweb.repository.interfaces.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CarreraRepository implements Repository<Carrera> {

    private EntityManager em;

    public CarreraRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Carrera c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Carrera c) {
        
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
//    public List<InfoCarreraDTO> getReporteCarreras() {
//        String statement = """
//            SELECT new InfoCarreraDTO (
//
//            FROM Carrera c JOIN CarreraEstudiante ce ON c.id = ce.carrera.id
//            GROUP BY c.id
//        """;
//        TypedQuery<Carrera> query = em.createQuery(statement, Carrera.class);
//        return query.getResultList();
//    }
    
}
