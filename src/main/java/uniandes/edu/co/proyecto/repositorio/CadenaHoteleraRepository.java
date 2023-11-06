package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.CadenaHoteleras;

public interface CadenaHoteleraRepository extends JpaRepository<CadenaHoteleras, Integer>{

    @Query (value = "SELECT * FROM cadenasHoteleras", nativeQuery = true)
    Collection<CadenaHoteleras> darCadenasHoteleras();

    @Query (value = "SELECT * FROM cadenasHoteleras WHERE id = :id", nativeQuery = true)
    CadenaHoteleras darCadenaHotelera(@Param("id") int id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO cadenasHoteleras (id, nombre) VALUES (?)", nativeQuery = true)
    void insertarCadenaHotelera(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query (value = "UPDATE cadenasHoteleras SET nombre = :nombre WHERE id = :id", nativeQuery = true)
    void actualizarCadenaHotelera(@Param("id") int id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query (value = "DELETE FROM cadenasHoteleras WHERE id = :id", nativeQuery = true)
    void eliminarCadenaHotelera(@Param("id") int id);
    
}
