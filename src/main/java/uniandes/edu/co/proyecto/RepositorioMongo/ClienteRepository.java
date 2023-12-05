package uniandes.edu.co.proyecto.RepositorioMongo;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modeloMongo.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, Integer> {

    @Query("{}")
    List<Cliente> findAll();

    @Query("{'_id': ?0}")
    Cliente buscarPorId(Integer id);
    
}