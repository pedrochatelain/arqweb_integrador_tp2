package exa.arqweb.repository;

import exa.arqweb.entity.Carrera;
import exa.arqweb.entity.Estudiante;
import exa.arqweb.entity.Inscripcion;
import exa.arqweb.repository.interfaces.Repository;
import jakarta.persistence.EntityManager;

public class InscripcionRepository implements Repository<Inscripcion> {

    private EntityManager em;

    public InscripcionRepository(EntityManager em) {
        this.em = em;
    }

    public void matricular(Estudiante estudiante, Carrera carrera) {
        em.getTransaction().begin();
        estudiante = em.find(Estudiante.class, estudiante.getID());
        carrera = em.find(Carrera.class, carrera.getID());
        Inscripcion ins = new Inscripcion(estudiante, carrera);
        em.persist(ins);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Inscripcion ins) {
    }

    @Override
    public void add(Inscripcion p) {
     
    }
    
}
