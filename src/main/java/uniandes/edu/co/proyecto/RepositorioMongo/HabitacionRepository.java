package uniandes.edu.co.proyecto.RepositorioMongo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modeloMongo.Habitacion;

import org.springframework.data.mongodb.repository.DeleteQuery;


public interface HabitacionRepository extends MongoRepository<Habitacion, String> {
    
    @Query("{}")
    List<Habitacion> findAll();

    @Query("{'_id': ?0}")
    Habitacion buscarPorId(Integer id);

    @Query("{'_id': ?0}")
    @Update("{$set: {'numero': ?1, 'tipoHabitacion': ?2, 'television': ?3, 'minibar': ?4, 'cafetera': ?5, 'diasEstadia': ?6, 'idHotel': ?7}}")
    void actualizarHabitacion(String id, Integer numero, String tipoHabitacion, Boolean television, Boolean minibar, Boolean cafetera, Integer diasEstadia, String idHotel);

    @DeleteQuery("{'_id': ?0}")
    void eliminarHabitacion(String id);
}