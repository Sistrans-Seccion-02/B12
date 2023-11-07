package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, String>{

    @Query(value = "SELECT * FROM tiposhabitacion", nativeQuery = true)
    Collection<TipoHabitacion> darTiposHabitacion();

    @Query(value = "SELECT * FROM tiposhabitacion WHERE nombre=:nombre", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposhabitacion (nombre, capacidad, costo) VALUES ( :nombre, :capacidad, :costo)", nativeQuery = true)
    void insertarTipoHabitacion(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("costo") Integer costo);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposhabitacion SET capacidad = :capacidad, costo=:costo WHERE nombre=:nombre", nativeQuery = true)
    void actualizarTipoHabitacion(@Param("nombre") String nombre, @Param("capacidad") Integer capacidad, @Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposhabitacion WHERE nombre=:nombre", nativeQuery = true)
    void eliminarTipoHabitacion(@Param("nombre") String nombre);

}
