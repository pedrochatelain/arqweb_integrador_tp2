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

        // a) dar de alta estudiantes
        EstudianteRepository repositoryEstudiante = FactoryRepository.mysql().getRepositoryEstudiante();

        Estudiante e1 = new Estudiante(1, "Peter", "Parker", 30, "Male", 2020202, "New York", 3);
        Estudiante e2 = new Estudiante(2, "John", "Doe", 22, "Male", 343433, "Tandil", 13);
        Estudiante e3 = new Estudiante(3, "Jane", "Eod", 19, "Female", 122323, "London", 243);
        Estudiante e4 = new Estudiante(4, "Michael", "Jackson", 34, "Male", 984433, "Washington DC", 94);

        repositoryEstudiante.add(e1); repositoryEstudiante.add(e2); repositoryEstudiante.add(e3); repositoryEstudiante.add(e4);

        // dar de alta carreras
        CarreraRepository carreraRepository = FactoryRepository.mysql().getRepositoryCarrera();

        Carrera c1 = new Carrera(1, "TUDAI");
        Carrera c2 = new Carrera(2, "Ingenieria en sistemas");
        Carrera c3 = new Carrera(3, "Veterinaria");
        Carrera c4 = new Carrera(4, "Abogacia");
        Carrera c5 = new Carrera(5, "Profesorado de matematica");

        carreraRepository.add(c1); carreraRepository.add(c2); carreraRepository.add(c3); carreraRepository.add(c4); carreraRepository.add(c5);

        // b) matricular estudiantes en carreras
        CarreraEstudianteRepository cer = (CarreraEstudianteRepository) FactoryRepository.mysql().getRepositoryCarreraEstudiante();
        cer.matricular(1, 2, 2008);
        cer.matricular(1, 3, 2010);
        cer.matricular(2, 3, 2009);
        cer.matricular(3, 4, 2009);
        cer.matricular(4, 5, 2008);

        // c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple
        EstudianteRepository er = FactoryRepository.mysql().getRepositoryEstudiante();
        List<Estudiante> estudiantesByName = er.getEstudiantesOrderByName();
        System.out.println("\n------------\nEjercicio c: ");
        estudiantesByName.forEach(System.out::println);

        // d) recuperar un estudiante, en base a su número de libreta universitaria.
        System.out.println("\n------------\nEjercicio d: ");
        System.out.println(er.getByLegajo(3));

        // e) recuperar todos los estudiantes, en base a su género.
        List<Estudiante> estudiantesByGenero = er.getByGenero("Male");
        System.out.println("\n------------\nEjercicio e: ");
        estudiantesByGenero.forEach(System.out::println);

        // f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
        List<CarrerasConInscriptosDTO> carrerasConInscriptos = carreraRepository.getCarrerasConInscriptos();
        System.out.println("\n------------\nEjercicio f: ");
        carrerasConInscriptos.forEach(System.out::println);

        // g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
        List<Estudiante> estudiantesDeVeterinaria = er.getEstudiantes("Veterinaria", "Tandil");
        System.out.println("\n------------\nEjercicio g: ");
        estudiantesDeVeterinaria.forEach(System.out::println);
    }

}
