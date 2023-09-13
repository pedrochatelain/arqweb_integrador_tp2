package exa.arqweb.repository;

import java.util.List;

import exa.arqweb.entity.Estudiante;
import exa.arqweb.repository.interfaces.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class EstudianteRepository implements Repository<Estudiante> {

private EntityManager em;

    public EstudianteRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Estudiante e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    // d) recuperar un estudiante, en base a su número de libreta universitaria.
    public Estudiante getByLegajo(int legajo) {
        String statement = """
            SELECT e
            FROM Estudiante e
            WHERE e.legajo LIKE :lega
        """;
        Query query = em.createQuery(statement).setParameter("lega", legajo);
        List<Estudiante> estudiantes = query.getResultList();
        return estudiantes.isEmpty() ? null : estudiantes.get(0);
    }

    // e) recuperar todos los estudiantes, en base a su género.
    public List<Estudiante> getByGenero(String genero) {
        String statement = """
            SELECT e
            FROM Estudiante e
            WHERE e.genero LIKE :gen
        """;
        Query query = em.createQuery(statement).setParameter("gen", genero);
        return query.getResultList();
    }

    @Override
    public void delete(Estudiante e) {
        
    }
    
}
