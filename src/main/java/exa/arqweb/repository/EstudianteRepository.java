package exa.arqweb.repository;

import exa.arqweb.entity.Estudiante;
import exa.arqweb.repository.interfaces.Repository;
import jakarta.persistence.EntityManager;

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

    @Override
    public void delete(Estudiante e) {
        
    }
    
}
