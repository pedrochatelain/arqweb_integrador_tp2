package exa.arqweb.repository;

import exa.arqweb.entity.Carrera;
import exa.arqweb.entity.Estudiante;
import exa.arqweb.entity.Inscripcion;
import exa.arqweb.repository.interfaces.Repository;
import exa.arqweb.utils.InscripcionKey;
import jakarta.persistence.EntityManager;

public class InscripcionRepository implements Repository<Inscripcion> {

    private EntityManager em;

    public InscripcionRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Inscripcion ins) {
        em.getTransaction().begin();
        Estudiante e = em.find(Estudiante.class, ins.getEstudiante().getID());
        Carrera c = em.find(Carrera.class, ins.getCarrera().getID());
        ins.setId(new InscripcionKey(e.getID(), c.getID()));
        ins.setEstudiante(e);
        ins.setCarrera(c);
        em.persist(ins);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Inscripcion ins) {
    }
    
}
