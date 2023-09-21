package exa.arqweb.repository;

import java.util.List;

import exa.arqweb.entity.Estudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class EstudianteRepository {

private EntityManager em;

    private static EstudianteRepository instance = null;

    private EstudianteRepository() {};

    public static EstudianteRepository getInstance(EntityManager em) {
        if (instance == null) {
            instance = new EstudianteRepository();
            instance.em = em;
        }
        return instance;
    }

    // a) dar de alta un estudiante
    public void add(Estudiante e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    // c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
    public List<Estudiante> getEstudiantesOrderByName() {
        String statement = """
            SELECT e
            FROM Estudiante e
            ORDER BY e.nombre DESC
        """;
        TypedQuery<Estudiante> query = em.createQuery(statement, Estudiante.class);
        return query.getResultList();
    }

    // d) recuperar un estudiante, en base a su número de libreta universitaria.
    public Estudiante getByLegajo(int legajo) {
        String statement = """
            SELECT e
            FROM Estudiante e
            WHERE e.legajo = :lega
        """;
        TypedQuery<Estudiante> query = em.createQuery(statement, Estudiante.class).setParameter("lega", legajo);
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
        TypedQuery<Estudiante> query = em.createQuery(statement, Estudiante.class).setParameter("gen", genero);
        return query.getResultList();
    }

    // g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
    public List<Estudiante> getEstudiantes(String carrera, String ciudad) {
        String statement = """
            SELECT e
            FROM Estudiante e JOIN CarreraEstudiante i ON e.id = i.estudiante.id JOIN Carrera c ON c.id = i.carrera.id
            WHERE c.nombre LIKE :carr AND e.ciudad LIKE :ciu
        """;
        TypedQuery<Estudiante> query = em.createQuery(statement, Estudiante.class)
            .setParameter("carr", carrera)
            .setParameter("ciu", ciudad);
        return query.getResultList();
    }
    
}
