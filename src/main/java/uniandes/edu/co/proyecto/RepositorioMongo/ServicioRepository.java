package uniandes.edu.co.proyecto.RepositorioMongo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modeloMongo.Servicio;

import org.springframework.data.mongodb.repository.DeleteQuery;


public interface ServicioRepository extends MongoRepository<Servicio, Integer> {

    @Query("{}")
    List<Servicio> findAll();

    @Query("{'_id': ?0}")
    Servicio buscarPorId(String id);

    @Query("{'_id': ?0}")
    @Update("{$set: {'nombre': ?1, 'capacidad': ?2, 'costoDanios': ?3}}")
    void actualizarServicio(Integer id, String nombre, Integer capacidad, Double costoDanios);

    @DeleteQuery("{'_id': ?0}")
    void eliminarServicio(Integer id);
    
}