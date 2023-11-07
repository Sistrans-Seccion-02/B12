/* 

package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Restaurante;

import java.util.*;


public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{

    @Query(value = "SELECT * FROM restaurantes", nativeQuery = true)
    Collection<Restaurante> darRestaurantes();

    @Query(value = "SELECT * FROM restaurantes WHERE id_servicio = :id_servicio", nativeQuery = true)
    Restaurante darRestaurante(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO restaurantes (capacidad, estilo) VALUES (:capacidad, :estilo)", nativeQuery = true)
    void insertarRestaurante(@Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurantes SET capacidad=:capacidad, estilo=:estilo WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actualizarRestaurante(@Param("id_servicio") int id_servicio, @Param("capacidad") Integer capacidad, @Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurantes WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarRestaurante(@Param("id_servicio") int id_servicio);
    
}

*/