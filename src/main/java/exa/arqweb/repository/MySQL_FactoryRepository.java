package exa.arqweb.repository;

import exa.arqweb.entity.Carrera;
import exa.arqweb.entity.Estudiante;
import exa.arqweb.entity.Inscripcion;
import exa.arqweb.repository.interfaces.FactoryRepository;
import exa.arqweb.repository.interfaces.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MySQL_FactoryRepository implements FactoryRepository {

    private static MySQL_FactoryRepository instance;
    private EntityManager em;

    private MySQL_FactoryRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
        this.em = emf.createEntityManager();
    }

    @Override
    public Repository<Carrera> getRepositoryCarrera() {
        return new CarreraRepository(em);
    }

    @Override
    public Repository<Estudiante> getRepositoryEstudiante() {
        return new EstudianteRepository(em);
    }

    @Override
    public Repository<Inscripcion> getRepositoryInscripcion() {
        return null;
    }

    public static FactoryRepository getInstance() {
        if (instance == null)
            return new MySQL_FactoryRepository();
        return instance;
    }

}

