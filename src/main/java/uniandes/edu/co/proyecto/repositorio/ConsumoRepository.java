package uniandes.edu.co.proyecto.repositorio;


import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Consumo;

//TODO falta por terminar, depende de clases no implementadas aun
//No se recomienda el uso por ahora
public interface ConsumoRepository extends JpaRepository<Consumo, Integer>{

    @Query(value = "SELECT * FROM consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();
    
    @Query(value = "SELECT * FROM consumos WHERE numero_factura = :numero_factura", nativeQuery = true)
    Consumo darConsumo(@Param("numero_factura") Integer numero_factura);

    //TODO complementar con facturas_numero
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO consumos (numero_factura, costo, fecha, habitaciones_numero) VALUES (:numero_factura, :costo, :fecha, :habitaciones_numero)", nativeQuery = true)
    void insertarConsumo(@Param("numero_factura") Integer numero_factura, @Param("costo") Integer costo, @Param("fecha") Date fecha, @Param("habitaciones_numero") Integer habitaciones_numero);

    //TODO complementar con facturas_numero
    @Modifying
    @Transactional
    @Query(value = "UPDATE consumos SET costo=:costo, fecha=:fecha, habitaciones_numero=:habitaciones_numero WHERE numero_factura=:numero_factura", nativeQuery = true)
    void actualizarConsumo(@Param("numero_factura") Integer numero_factura, @Param("costo") Integer costo, @Param("fecha") Date fecha, @Param("habitaciones_numero") Integer habitaciones_numero);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM consumos WHERE numero_factura=:numero_factura", nativeQuery = true)
    void eliminarConsumo(@Param("numero_factura") Integer numero_factura);

}
