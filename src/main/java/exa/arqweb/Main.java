package exa.arqweb;

import exa.arqweb.entity.Carrera;
import exa.arqweb.entity.Estudiante;
import exa.arqweb.repository.interfaces.FactoryRepository;
import exa.arqweb.repository.interfaces.Repository;

public class Main {

    public static void main( String[] args ) {

        // Repository<Carrera> repositoryCarrera = FactoryRepository.mysql().getRepositoryCarrera();
        // repositoryCarrera.add(new Carrera("lapendejada"));

        // Creo estudiante y lo agrego a la db
        Repository<Estudiante> repositoryEstudiante = FactoryRepository.mysql().getRepositoryEstudiante();
        Estudiante e = new Estudiante(
            "John", 
            "Doe", 
            40, 
            "Male", 
            2020202, 
            "London", 
            3993,
            true
        );
        
        repositoryEstudiante.add(e);

    }

}
