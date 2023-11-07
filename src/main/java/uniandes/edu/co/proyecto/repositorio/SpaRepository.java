/* 

package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import uniandes.edu.co.proyecto.modelo.Spa;



public interface SpaRepository extends JpaRepository<Spa, Integer>{

    @Query(value = "SELECT * FROM spas", nativeQuery = true)
    Collection<Spa> darServiciosSpa();

    @Query(value = "SELECT * FROM spas WHERE id_servicio = :id_servicio", nativeQuery = true)
    Spa darServicioSpa(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spas (costo) VALUES (:costo)", nativeQuery = true)
    void insertarServicioSpa(@Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE spas SET costo=:costo WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actualizarServicioSpa(@Param("id_servicio") int id_servicio, @Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spas WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarServicioSpa(@Param("id_servicio") int id_servicio);
    
}

*/