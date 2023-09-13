package exa.arqweb.repository;

import java.util.List;

import exa.arqweb.entity.Carrera;
import exa.arqweb.repository.interfaces.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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
    public List<Carrera> getCarrerasConInscriptos() {
        String statement = """
            SELECT c
            FROM Carrera c JOIN Inscripcion i ON c.id = i.carrera.id
            GROUP BY c.id
        """;
        Query query = em.createQuery(statement);
        return query.getResultList();
    }
    
}
