/* 

package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Lavanderia;

import java.util.*;


public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer>{

    @Query(value = "SELECT * FROM lavanderias", nativeQuery = true)
    Collection<Lavanderia> darLavanderias();

    @Query(value = "SELECT * FROM lavanderias WHERE id_servicio = :id_servicio", nativeQuery = true)
    Lavanderia darLavanderia(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO lavanderias (costo) VALUES (:costo)", nativeQuery = true)
    void insertarLavanderia(@Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE lavanderias SET costo=:costo WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actualizarLavanderia(@Param("id_servicio") int id_servicio, @Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM lavanderias WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarLavanderia(@Param("id_servicio") int id_servicio);
    
}

*/

