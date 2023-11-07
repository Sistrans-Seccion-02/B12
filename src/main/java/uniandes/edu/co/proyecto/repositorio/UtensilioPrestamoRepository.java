/* 

package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.UtensilioPrestamo;

import java.util.*;


public interface UtensilioPrestamoRepository extends JpaRepository<UtensilioPrestamo, Integer>{

    @Query(value = "SELECT * FROM utensiliosprestamo", nativeQuery = true)
    Collection<UtensilioPrestamo> darUtensiliosPrestamo();

    @Query(value = "SELECT * FROM utensiliosprestamo WHERE id_servicio = :id_servicio", nativeQuery = true)
    UtensilioPrestamo darUtensilioPrestamo(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO utensiliosprestamo (prestado, devuelto, mal_estado, costo_extra) VALUES (:prestado, :devuelto, :mal_estado, :costo_extra)", nativeQuery = true)
    void insertarUtensilioPrestamo(@Param("prestado") Boolean prestado, @Param("devuelto") Boolean devuelto, @Param("mal_estado") Boolean mal_estado,  @Param("costo_extra") Integer costo_extra);

    @Modifying
    @Transactional
    @Query(value = "UPDATE utensiliosprestamo SET prestado=:prestado, devuelto=:devuelto, mal_estado=:mal_estado, costo_extra=:costo_extra WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actualizarUtensilioPrestamo(@Param("id_servicio") int id_servicio, @Param("prestado") Boolean prestado, @Param("devuelto") Boolean devuelto, @Param("mal_estado") Boolean mal_estado,  @Param("costo_extra") Integer costo_extra);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM utensiliosprestamo WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarUtensilioPrestamo(@Param("id_servicio") int id_servicio);
    
}

*/

