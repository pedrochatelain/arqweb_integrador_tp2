package exa.arqweb.factory;

import exa.arqweb.repository.CarreraEstudianteRepository;
import exa.arqweb.repository.CarreraRepository;
import exa.arqweb.repository.EstudianteRepository;
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
    public CarreraRepository getRepositoryCarrera() {
        return new CarreraRepository(em);
    }

    @Override
    public EstudianteRepository getRepositoryEstudiante() {
        return new EstudianteRepository(em);
    }

    @Override
    public CarreraEstudianteRepository getRepositoryCarreraEstudiante() {
        return new CarreraEstudianteRepository(em);
    }

    public static FactoryRepository getInstance() {
        if (instance == null)
            return new MySQL_FactoryRepository();
        return instance;
    }

}

