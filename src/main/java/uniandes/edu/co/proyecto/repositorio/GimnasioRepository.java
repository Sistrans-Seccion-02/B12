/* 
package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Gimnasio;

import java.util.*;


public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer>{

     @Query(value = "SELECT * FROM gimnasios", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasios WHERE id_servicio = :id_servicio", nativeQuery = true)
    Gimnasio darGimnasio(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (horario, capacidad) VALUES (:horario, :capacidad)", nativeQuery = true)
    void insertarGimnasio(@Param("horario") Date horario, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET horario=:horario, capacidad=:capacidad WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actualizarGimnasio(@Param("id_servicio") int id_servicio, @Param("horario") Date horario, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarGimnasio(@Param("id_servicio") int id_servicio);



    
}
*/