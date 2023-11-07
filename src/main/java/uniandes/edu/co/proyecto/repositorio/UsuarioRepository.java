package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    @Query(value = "SELECT * FROM usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();


    @Query(value = "SELECT * FROM usuarios WHERE numero_documento= :numero_documento", nativeQuery = true)
    Usuario darUsuario(@Param("numero_documento") int numero_documento);

  
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuarios (numero_documento, tipo_documento, email, nombre, fecha_entrada, fecha_salida, tiposusuario_nombre, planesconsumo_nombre) VALUES(:numero_documento, :tipo_documento, :email, :nombre, :fecha_entrada, :fecha_salida, :tiposusuario_nombre, :planesconsumo_nombre)", nativeQuery = true)
    void insertarUsuario(@Param("numero_documento")Integer numero_documento, @Param("tipo_documento") String tipo_documento, @Param("email") String email,  @Param("nombre") String nombre,  @Param("fecha_entrada") Date fecha_entrada, @Param("fecha_salida") Date fecha_salida,  @Param("tiposusuario_nombre") String tiposusuario_nombre, @Param("planesconsumo_nombre") String planesconsumo_nombre);


    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET tipo_documento=:tipo_documento, email=:email, nombre=:nombre, fecha_entrada=:fecha_entrada, fecha_salida=:fecha_salida, tiposusuario_nombre=:tiposusuario_nombre, planesconsumo_nombre=:planesconsumo_nombre  WHERE numero_documento=:numero_documento", nativeQuery = true)
    void actualizarUsuario(@Param("numero_documento")Integer numero_documento, @Param("tipo_documento") String tipo_documento, @Param("email") String email,  @Param("nombre") String nombre,  @Param("fecha_entrada") Date fecha_entrada, @Param("fecha_salida") Date fecha_salida,  @Param("tiposusuario_nombre") String tiposusuario_nombre, @Param("planesconsumo_nombre") String planesconsumo_nombre);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE numero_documento=:numero_documento", nativeQuery = true)
    void eliminarUsuario(@Param("numero_documento") Integer numero_documento);
    
}
