package uniandes.edu.co.proyecto.repositorio;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion,Integer>{

    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();


    @Query(value = "SELECT * FROM habitaciones WHERE numero= :numero", nativeQuery = true)
    Habitacion darHabitacion(@Param("numero") int numero);

  
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (numero, tiposhabitacion_nombre) VALUES( :numero, :tiposhabitacion_nombre)", nativeQuery = true)
    void insertarHabitacion(@Param("numero")Integer numero, @Param("tiposhabitacion_nombre") String tiposhabitacion_nombre);


    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET tiposhabitacion_nombre=:tiposhabitacion_nombre WHERE numero=:numero", nativeQuery = true)//PILAS AQUI, TOCA CONTINUAR
    void actualizarHabitacion(@Param("numero") Integer numero, @Param("tiposhabitacion_nombre") String tiposhabitacion_nombre);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE numero=:numero", nativeQuery = true)
    void eliminarHabitacion(@Param("numero") Integer numero);
    
}
