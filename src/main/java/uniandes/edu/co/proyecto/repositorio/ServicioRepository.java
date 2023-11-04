package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer>{

    @Query (value = "SELECT * FROM Servicios", nativeQuery = true)
    Collection<Servicio> darServicios();


    @Query (value = "SELECT * FROM Servicios WHERE id = :id", nativeQuery = true)
    Servicio darServicio(@Param("id") int id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO Servicios (id, nombre, capacidad, tipo) VALUES (?,?)", nativeQuery = true)
    void insertarServicio(@Param("nombre") String nombre, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query (value = "UPDATE Servicios SET nombre = :nombre, capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("id") int id, @Param("nombre") String Servicio, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query (value = "DELETE FROM Servicios WHERE id = :id", nativeQuery = true)
    void eliminarServicio(@Param("id") int id);
    
}