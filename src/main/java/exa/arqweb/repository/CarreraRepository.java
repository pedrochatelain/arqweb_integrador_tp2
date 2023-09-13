package exa.arqweb.repository;

import exa.arqweb.entity.Carrera;
import exa.arqweb.repository.interfaces.Repository;
import jakarta.persistence.EntityManager;

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

    
}
