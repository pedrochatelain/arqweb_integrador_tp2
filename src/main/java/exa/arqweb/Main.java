package exa.arqweb;

import exa.arqweb.dto.CarrerasConInscriptosDTO;
import exa.arqweb.entity.Carrera;
import exa.arqweb.entity.CarreraEstudiante;
import exa.arqweb.entity.Estudiante;
import exa.arqweb.factory.FactoryRepository;
import exa.arqweb.repository.CarreraEstudianteRepository;
import exa.arqweb.repository.CarreraRepository;
import exa.arqweb.repository.EstudianteRepository;

import java.util.List;

public class Main {

    public static void main( String[] args ) {

        // a) dar de alta un estudiante
//        Estudiante e = new Estudiante(92, "Nombre", "apellido", 34, "Male", 3030303, "New York", 3);
//        EstudianteRepository er = FactoryRepository.mysql().getRepositoryEstudiante();
//        er.add(e);

        // b) matricular un estudiante en una carrera
//        Estudiante e2 = new Estudiante(293, "xwdw", "jiojwdowdj", 49, "Female", 399393, "Tandil", 938);
//        Carrera c = new Carrera(1233, "Carrera 01");
//        CarreraEstudianteRepository cer = FactoryRepository.mysql().getRepositoryCarreraEstudiante();
//        cer.matricular(new CarreraEstudiante(e2, c, 2009));

        // c) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
//        EstudianteRepository er = FactoryRepository.mysql().getRepositoryEstudiante();
//        er.getEstudiantesOrderByName().forEach(System.out::println);

        // d) recuperar un estudiante, en base a su número de libreta universitaria.
//        EstudianteRepository er = FactoryRepository.mysql().getRepositoryEstudiante();
//        System.out.println(er.getByLegajo(938));

        // e) recuperar todos los estudiantes, en base a su género.
//        EstudianteRepository er = FactoryRepository.mysql().getRepositoryEstudiante();
//        er.getByGenero("male").forEach(System.out::println);

        // f) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
//        CarreraRepository cr = FactoryRepository.mysql().getRepositoryCarrera();
//        cr.getCarrerasConInscriptos().forEach(System.out::println);

        // g) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
//        EstudianteRepository er = FactoryRepository.mysql().getRepositoryEstudiante();
//        er.getEstudiantes("Ingenieria en sistemas", "Tandil").forEach(System.out::println);

        // 3) Generar un reporte de las carreras, que para cada carrera incluya información de los
        //    inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, y presentar
        //    los años de manera cronológica.
//        CarreraRepository cr = FactoryRepository.mysql().getRepositoryCarrera();
//        cr.getReporteCarreras().forEach(System.out::println);

    }

}
