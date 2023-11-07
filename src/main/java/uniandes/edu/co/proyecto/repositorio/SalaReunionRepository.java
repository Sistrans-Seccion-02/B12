/* 

package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import uniandes.edu.co.proyecto.modelo.SalaReunion;




public interface SalaReunionRepository extends JpaRepository<SalaReunion, Integer>{

    @Query(value = "SELECT * FROM salasreuniones", nativeQuery = true)
    Collection<SalaReunion> darSalasReuniones();

    @Query(value = "SELECT * FROM salasreuniones WHERE id_servicio = :id_servicio", nativeQuery = true)
    SalaReunion darSalaReunion(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salasreuniones (costo, capacidad, equipo_extra) VALUES (:costo, :capacidad, :equipo_extra)", nativeQuery = true)
    void insertarSalaReunion(@Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("equipo_extra") Boolean equipo_extra);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salasreuniones SET costo=:costo, capacidad=:capacidad, equipo_extra=:equipo_extra WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actualizarSalaReunion(@Param("id_servicio") int id_servicio, @Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("equipo_extra") Boolean equipo_extra);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salasreuniones WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarSalaReunion(@Param("id_servicio") int id_servicio);
    
}

*/
