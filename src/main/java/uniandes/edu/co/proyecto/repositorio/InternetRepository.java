/* 

package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import uniandes.edu.co.proyecto.modelo.Internet;




public interface InternetRepository extends JpaRepository<Internet, Integer>{

    @Query(value = "SELECT * FROM internets", nativeQuery = true)
    Collection<Internet> darInternets();

    @Query(value = "SELECT * FROM internets WHERE id_servicio = :id_servicio", nativeQuery = true)
    Internet darInternet(@Param("id_servicio") int id_servicio);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internets (costo, capacidad) VALUES (:costo, :capacidad)", nativeQuery = true)
    void insertarInternet(@Param("costo") Integer costo, @Param("capacidad") String string);

    @Modifying
    @Transactional
    @Query(value = "UPDATE internets SET costo=:costo, capacidad=:capacidad WHERE id_servicio = :id_servicio", nativeQuery = true)
    void actualizarInternet(@Param("id_servicio") int id_servicio, @Param("costo") Integer costo, @Param("capacidad") String string);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM internets WHERE id_servicio = :id_servicio", nativeQuery = true)
    void eliminarInternet(@Param("id_servicio") int id_servicio);
    
}

*/
