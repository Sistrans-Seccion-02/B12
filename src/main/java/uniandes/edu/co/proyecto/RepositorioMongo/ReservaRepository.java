package com.example.demo.repositorio;

import java.util.List;
import java.util.Date;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.mongodb.repository.DeleteQuery;

import com.example.demo.modelo.*;

import uniandes.edu.co.proyecto.modeloMongo.Reserva;

public interface ReservaRepository extends MongoRepository<Reserva, String> {
        
        @Query("{}")
        List<Reserva> findAll();
    
        @Query("{'_id': ?0}")
        Reserva buscarPorId(String id);
    
        @Query("{'_id': ?0}")
        @Update("{$set: {'costoTotal': ?1, 'fecha_inicio': ?2, 'fecha_fin': ?3, 'planes_estadia': ?4, 'usuario': db.usuarios.find({id: ?5}), 'habitacion': db.habitaciones.find({numero:?6})._id}}")
        void actualizarReserva(String id, Double costoTotal, Date fecha_inicio, Date fecha_fin, String planes_estadia, String usuarios, Integer habitaciones);
    
        @DeleteQuery("{'_id': ?0}")
        void eliminarReserva(String id);

        @Query("{'_id': ?0}")
        @Update("{$set: {'estado': ?1}}")
        void actualizarEstado(String id, String estado);
    
}