package exa.arqweb;

import exa.arqweb.entity.Carrera;
import exa.arqweb.entity.Estudiante;
import exa.arqweb.repository.CarreraRepository;
import exa.arqweb.repository.EstudianteRepository;
import exa.arqweb.repository.InscripcionRepository;
import exa.arqweb.repository.interfaces.FactoryRepository;

public class Main {

    public static void main( String[] args ) {

        // Creo estudiante y lo agrego a la db
        EstudianteRepository repositoryEstudiante = (EstudianteRepository) FactoryRepository.mysql().getRepositoryEstudiante();
        Estudiante e = new Estudiante(
            192,
            "John", 
            "Doe", 
            40, 
            "Male", 
            2020202, 
            "London", 
            3,
            false
        );
        repositoryEstudiante.add(e);

        // Creo carrera y la agrego a la db
        CarreraRepository carreraRepository = (CarreraRepository) FactoryRepository.mysql().getRepositoryCarrera();
        Carrera c = new Carrera(1, "TUDAI");
        carreraRepository.add(c);

        // Matriculo al estudiante "e" en la carrera "c"
        InscripcionRepository inscripcionRepository = (InscripcionRepository) FactoryRepository.mysql().getRepositoryInscripcion();
        inscripcionRepository.matricular(e, c);
        
    }

}
