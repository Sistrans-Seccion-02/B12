package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{

    @Query (value = "SELECT * FROM Habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitacions();

    @Query (value = "SELECT * FROM Habitaciones WHERE id = :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO Habitaciones (id, numero, costo, tipo, capacidad) VALUES (?,?,?,?)", nativeQuery = true)
    void insertarHabitacion(@Param("numero") int numero, @Param("costo")int costo, @Param("tipo") String tipo, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query (value = "UPDATE Habitaciones SET numero = :numero, costo = :costo, tipo = :tipo, capacidad = :capacidad WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("id") int id, @Param("numero") int numero, @Param("costo")int costo, @Param("tipo") String tipo, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query (value = "DELETE FROM Habitaciones WHERE id = :id", nativeQuery = true)
    void eliminarHabitacion(@Param("id") int id);
    
}