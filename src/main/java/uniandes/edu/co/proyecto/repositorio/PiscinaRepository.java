package uniandes.edu.co.proyecto.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Piscina;
import java.util.*;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer>{

    @Query(value = "SELECT * FROM piscinas", nativeQuery = true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT * FROM piscinas WHERE id_servicio = :id_servicio", nativeQuery = true)
    Piscina darPiscina(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas (horario, capacidad, profundidad) VALUES (:horario, :capacidad, :profundidad)", nativeQuery = true)
    void insertarPiscina(@Param("horario") String horario, @Param("capacidad") Integer capacidad, @Param("profundidad") Integer profundidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET horario=:horario, capacidad=:capacidad, profundidad=:profundidad WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actulizarPiscina(@Param("id_servicio") int id_servicio, @Param("horario") String horario, @Param("capacidad") Integer capacidad, @Param("profundidad") Integer profundidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarPiscina(@Param("id_servicio") int id_servicio);

    
}
