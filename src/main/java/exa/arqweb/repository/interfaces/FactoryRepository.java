package exa.arqweb.repository.interfaces;

import exa.arqweb.entity.Carrera;
import exa.arqweb.entity.Estudiante;
import exa.arqweb.entity.Inscripcion;
import exa.arqweb.repository.MySQL_FactoryRepository;

public interface FactoryRepository {
    
    Repository<Carrera> getRepositoryCarrera();
    Repository<Estudiante> getRepositoryEstudiante();
    Repository<Inscripcion> getRepositoryInscripcion();

    static FactoryRepository mysql() {
        return MySQL_FactoryRepository.getInstance();
    }

}
