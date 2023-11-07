package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

import java.util.*;

//En esta parte falta tomar en cuenta el atributo de Consumos_numero_factura que es FK de la PK de la clase Consumo

public interface ServicioRepository extends JpaRepository<Servicio, Integer>{

    @Query(value = "SELECT * FROM servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM servicios WHERE id = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (nombre, descripcion) VALUES (:nombre, :descripcion)", nativeQuery = true)
    void insertarServicio(@Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET nombre=:nombre, descripcion=:descripcion WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") int id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") int id);
    
}