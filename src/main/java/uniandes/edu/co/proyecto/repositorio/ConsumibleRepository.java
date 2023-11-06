package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumible;

public interface ConsumibleRepository extends JpaRepository<Consumible, Integer>{

    @Query (value = "SELECT * FROM consumibles", nativeQuery = true)
    Collection<Consumible> darConsumibles();

    @Query (value = "SELECT * FROM consumibles WHERE id = :id", nativeQuery = true)
    Consumible darConsumible(@Param("id") int id);

    @Modifying
    @Transactional
    @Query (value = "INSERT INTO consumibles (id, consumible, valor) VALUES (?,?)", nativeQuery = true)
    void insertarConsumible(@Param("consumible") String consumible, @Param("valor")float valor);

    @Modifying
    @Transactional
    @Query (value = "UPDATE consumibles SET consumible = :consumible, valor = :valor WHERE id = :id", nativeQuery = true)
    void actualizarConsumible(@Param("id") int id, @Param("consumible") String consumible, @Param("valor")float valor);

    @Modifying
    @Transactional
    @Query (value = "DELETE FROM consumibles WHERE id = :id", nativeQuery = true)
    void eliminarConsumible(@Param("id") int id);
    
}