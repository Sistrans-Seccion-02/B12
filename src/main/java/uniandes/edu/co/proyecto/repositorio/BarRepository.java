/* 
package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bar;

import java.util.*;


public interface BarRepository extends JpaRepository<Bar, Integer>{

    @Query(value = "SELECT * FROM bares", nativeQuery = true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM bares WHERE id_servicio = :id_servicio", nativeQuery = true)
    Bar darBar(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (capacidad, estilo) VALUES (:capacidad, :estilo)", nativeQuery = true)
    void insertarBar(@Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET capacidad=:capacidad, estilo=:estilo WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actualizarBar(@Param("id_servicio") int id_servicio, @Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarBar(@Param("id_servicio") int id_servicio);
    
}

*/
