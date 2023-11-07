package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, String>{

    @Query(value = "SELECT * FROM tiposusuario", nativeQuery = true)
    Collection<TipoUsuario> darTiposUsuario();

    @Query(value = "SELECT * FROM tiposusuario WHERE nombre=:nombre", nativeQuery = true)
    TipoUsuario darTipoUsuario(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiposusuario (nombre, descripcion) VALUES ( :nombre, :descripcion)", nativeQuery = true)
    void insertarTipoUsuario(@Param("nombre") String nombre, @Param("descripcion") String descripcion);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE tiposusuario SET descripcion = :descripcion WHERE nombre=:nombre", nativeQuery = true)
    void actualizarTipoUsuario(@Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiposusuario WHERE nombre=:nombre", nativeQuery = true)
    void eliminarTipoUsuario(@Param("nombre") String nombre);

}
