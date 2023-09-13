package exa.arqweb;

import exa.arqweb.entity.Carrera;
import exa.arqweb.repository.interfaces.FactoryRepository;
import exa.arqweb.repository.interfaces.Repository;

public class Main {

    public static void main( String[] args ) {

        Repository<Carrera> repositoryCarrera = FactoryRepository.mysql().getRepositoryCarrera();
        
        repositoryCarrera.add(new Carrera("random career"));

    }

}
