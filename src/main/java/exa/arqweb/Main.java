package exa.arqweb;

import exa.arqweb.dto.CarrerasConInscriptosDTO;
import exa.arqweb.entity.Carrera;
import exa.arqweb.entity.Estudiante;
import exa.arqweb.factory.FactoryRepository;
import exa.arqweb.repository.CarreraEstudianteRepository;
import exa.arqweb.repository.CarreraRepository;
import exa.arqweb.repository.EstudianteRepository;

import java.util.List;

public class Main {

    public static void main( String[] args ) {

//        CarreraEstudianteRepository cer = FactoryRepository.mysql().getRepositoryCarreraEstudiante();
//        cer.matricular(1, 5, 2099);
        CarreraRepository cr = FactoryRepository.mysql().getRepositoryCarrera();
        cr.getReporteCarreras().forEach(System.out::println);

    }

}
