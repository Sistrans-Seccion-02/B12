/* 
package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.SalaConferencia;

import java.util.*;

public interface SalaConferenciaRepository extends JpaRepository<SalaConferencia, Integer>{

    @Query(value = "SELECT * FROM salasconferencias", nativeQuery = true)
    Collection<SalaConferencia> darSalasConferencia();

    @Query(value = "SELECT * FROM salasconferencias WHERE id_servicio = :id_servicio", nativeQuery = true)
    SalaConferencia darSalaConferencia(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salasconferencias (costo, capacidad) VALUES (:costo, :capacidad)", nativeQuery = true)
    void insertarSalaConferencia(@Param("costo") Integer costo, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salasconferencias SET costo=:costo, capacidad=:capacidad WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actualizarSalaConferencia(@Param("id_servicio") int id_servicio, @Param("costo") Integer costo, @Param("capacidad") Integer capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salasconferencias WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarSalaConferencia(@Param("id_servicio") int id_servicio);
    
}

*/
