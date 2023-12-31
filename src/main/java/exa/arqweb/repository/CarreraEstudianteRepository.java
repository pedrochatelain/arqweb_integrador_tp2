package exa.arqweb.repository;

import exa.arqweb.entity.Carrera;
import exa.arqweb.entity.Estudiante;
import exa.arqweb.entity.CarreraEstudiante;
import exa.arqweb.utils.CarreraEstudianteKey;
import jakarta.persistence.EntityManager;

public class CarreraEstudianteRepository {

    private EntityManager em;
    private static CarreraEstudianteRepository instance = null;

    private CarreraEstudianteRepository() {}

    public static CarreraEstudianteRepository getInstance(EntityManager em) {
        if (instance == null) {
            instance = new CarreraEstudianteRepository();
            instance.em = em;
        }
        return instance;
    }

    // b) matricular un estudiante en una carrera
    public void matricular(int id_estudiante, int id_carrera, int anio_inscripcion) {
        em.getTransaction().begin();
        Estudiante estudiante = em.find(Estudiante.class, id_estudiante);
        Carrera carrera = em.find(Carrera.class, id_carrera);
        CarreraEstudiante inscripcion = new CarreraEstudiante(estudiante, carrera, anio_inscripcion);
        em.persist(inscripcion);
        em.getTransaction().commit();
    }

    public void matricular(CarreraEstudiante ce) {
        em.getTransaction().begin();
        em.persist(ce);
        em.getTransaction().commit();
    }

    public void graduar(int id_estudiante, int id_carrera, int anio_graduacion) {
        em.getTransaction().begin();
        CarreraEstudianteKey key = new CarreraEstudianteKey(id_estudiante, id_carrera);
        CarreraEstudiante carreraEstudiante = em.find(CarreraEstudiante.class, key);
        if (anio_graduacion >= carreraEstudiante.getAnioInscripcion()) {
            carreraEstudiante.setAnioGraduacion(anio_graduacion);
        }
        em.getTransaction().commit();
    }
    
}
