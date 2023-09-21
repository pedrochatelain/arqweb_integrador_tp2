package exa.arqweb.factory;

import exa.arqweb.repository.CarreraEstudianteRepository;
import exa.arqweb.repository.CarreraRepository;
import exa.arqweb.repository.EstudianteRepository;

public interface FactoryRepository {
    
    CarreraRepository getRepositoryCarrera();
    EstudianteRepository getRepositoryEstudiante();
    CarreraEstudianteRepository getRepositoryCarreraEstudiante();

    static FactoryRepository mysql() {
        return MySQL_FactoryRepository.getInstance();
    }

}
