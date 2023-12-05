package uniandes.edu.co.proyecto.RepositorioMongo;

import java.util.List;
import java.util.Date;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.mongodb.repository.DeleteQuery;

import uniandes.edu.co.proyecto.modeloMongo.Consumo;

public interface ConsumoRepository extends MongoRepository<Consumo, Integer> {
            
        @Query("{}")
        List<Consumo> findAll();
    
        @Query("{'_id': ?0}")
        Consumo buscarPorId(Integer id);
    
        @Query("{'_id': ?0}")
        @Update("{$set: {'costo': ?1, 'fecha': ?2, 'valorTotal': ?3, 'servicio': db.servicios.find({id: ?4})}}")
        void actualizarConsumo(Integer id, Date fecha, Double valorTotal, String servicio);
    
        @DeleteQuery("{'_id': ?0}")
        void eliminarConsumo(Integer id);

}