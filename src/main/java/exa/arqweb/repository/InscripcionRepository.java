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

    // b) matricular un estudiante en una carrera
    public void matricular(int id_estudiante, int id_carrera, int anio_inscripcion) {
        em.getTransaction().begin();
        Estudiante estudiante = em.find(Estudiante.class, id_estudiante);
        Carrera carrera = em.find(Carrera.class, id_carrera);
        Inscripcion ins = new Inscripcion(estudiante, carrera, anio_inscripcion);
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
